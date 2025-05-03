package com.java.broker.factory;

import com.binance.connector.client.impl.SpotClientImpl;
import com.java.broker.entity.UserEntity;

public interface ApiClientFactory {
    SpotClientImpl createClient(UserEntity user);
}
