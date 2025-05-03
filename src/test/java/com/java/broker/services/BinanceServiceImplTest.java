package com.java.broker.services;

import com.binance.connector.client.impl.SpotClientImpl;
import com.binance.connector.client.impl.spot.Trade;
import com.binance.connector.client.impl.spot.Wallet;
import com.java.broker.entity.UserEntity;
import com.java.broker.factory.ApiClientFactory;
import com.java.broker.repository.UserRepository;
import com.java.broker.services.impl.BinanceServiceImpl;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BinanceServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private ApiClientFactory apiClientFactory;

    @Mock
    private BalanceExtractorService balanceExtractorService;

    @Mock
    private SpotClientImpl spotClient;

    @InjectMocks
    private BinanceServiceImpl binanceService;

    private UserEntity user;

    @BeforeEach
    void setUp() {
        user = new UserEntity();
        user.setEmail("test@example.com");
    }


    @Test
    void getAccountInfo_ShouldReturnAccountStatus() {

        Wallet wallet = mock(Wallet.class);
        when(spotClient.createWallet()).thenReturn(wallet);
        when(wallet.accountStatus(anyMap())).thenReturn("{\"data\":\"Normal\"}");

        when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.of(user));
        when(apiClientFactory.createClient(user)).thenReturn(spotClient);

        String result = binanceService.getAccountInfo(user.getEmail());

        assertEquals("{\"data\":\"Normal\"}", result);
        verify(userRepository).findByEmail(user.getEmail());
        verify(apiClientFactory).createClient(user);
    }


    @Test
    void getAccountBalance_ShouldReturnBalance() {

        Trade trade = mock(Trade.class);
        when(spotClient.createTrade()).thenReturn(trade);
        when(trade.account(anyMap())).thenReturn("{\"balances\":[]}");

        when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.of(user));
        when(apiClientFactory.createClient(user)).thenReturn(spotClient);

        when(balanceExtractorService.extractBalance(any(org.json.JSONArray.class)))
                .thenReturn(new JSONObject());

        String result = binanceService.getAccountBalance(user.getEmail());

        assertEquals("{}", result);
        verify(userRepository).findByEmail(user.getEmail());
        verify(apiClientFactory).createClient(user);
        verify(balanceExtractorService).extractBalance(any(org.json.JSONArray.class));
    }
}