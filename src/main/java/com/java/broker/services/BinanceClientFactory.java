package com.java.broker.services;

import com.binance.connector.client.impl.SpotClientImpl;
import com.java.broker.entity.BinanceEntity;
import com.java.broker.entity.UserEntity;
import com.java.broker.repository.BinanceRepository;
import com.java.broker.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BinanceClientFactory {

    private final UserRepository userRepository;
    private final BinanceRepository binanceRepository;

    public SpotClientImpl create(String email) {
        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found: " + email));

        BinanceEntity binance = binanceRepository.findByUserId(user.getId())
                .orElseThrow(() -> new RuntimeException("Binance keys not found for: " + email));

        return new SpotClientImpl(binance.getApiKey(), binance.getSecretKey());
    }
}

