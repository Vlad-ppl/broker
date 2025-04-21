package com.java.broker.services;

import com.java.broker.dto.BinanceDto;
import com.java.broker.entity.BinanceEntity;
import com.java.broker.entity.UserEntity;
import com.java.broker.repository.BinanceRepository;
import com.java.broker.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BinanceService {

    private final BinanceRepository binanceRepository;
    private final UserRepository userRepository;

    public BinanceEntity save(BinanceDto binanceDto) {
        UserEntity user = userRepository.findById(binanceDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        BinanceEntity binanceEntity = BinanceEntity.builder()
                .apiKey(binanceDto.getApiKey())
                .secretKey(binanceDto.getSecretKey())
                .user(user)
                .build();
        return binanceRepository.save(binanceEntity);
    }
}
