package com.java.broker.factory.impl;

import com.binance.connector.client.impl.SpotClientImpl;
import com.java.broker.entity.BinanceEntity;
import com.java.broker.entity.UserEntity;
import com.java.broker.factory.ApiClientFactory;
import org.springframework.stereotype.Component;

@Component
public class BinanceApiClientFactory implements ApiClientFactory {
    @Override
    public SpotClientImpl createClient(UserEntity user) {
        BinanceEntity binanceAccount = user.getBinanceAccounts().get(0);
        return new SpotClientImpl(binanceAccount.getApiKey(), binanceAccount.getSecretKey());
    }
}
