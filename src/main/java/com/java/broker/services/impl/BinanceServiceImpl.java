package com.java.broker.services.impl;

import com.java.broker.entity.UserEntity;
import com.java.broker.factory.ApiClientFactory;
import com.java.broker.repository.UserRepository;
import com.java.broker.services.BalanceExtractorService;
import com.java.broker.services.BrokerService;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BinanceServiceImpl implements BrokerService {

    private final UserRepository userRepository;
    private final ApiClientFactory binanceApiClientFactory;
    private final BalanceExtractorService balanceExtractorService;

    @Override
    public String getAccountInfo(String email) {
        UserEntity user = getUserByEmailWithAccounts(email);
        var client = binanceApiClientFactory.createClient(user);

        return client.createWallet().accountStatus(new LinkedHashMap<>());
    }

    @Override
    public String getAccountBalance(String email) {
        UserEntity user = getUserByEmailWithAccounts(email);
        var client = binanceApiClientFactory.createClient(user);

        Map<String, Object> params = new LinkedHashMap<>();
        String response = client.createTrade().account(params);

        JSONObject json = new JSONObject(response);
        JSONArray balances = json.getJSONArray("balances");

        return balanceExtractorService.extractBalance(balances).toString();
    }

    private UserEntity getUserByEmailWithAccounts(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
    }
}
