package com.java.broker.controller;

import com.java.broker.dto.BinanceDto;
import com.java.broker.entity.BinanceEntity;
import com.java.broker.services.BinanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/binance")
@RequiredArgsConstructor
public class BinanceController {

    private final BinanceService binanceService;

    @PostMapping("/add")
    public ResponseEntity<BinanceEntity> addBinanceAccount(@RequestBody BinanceDto dto) {
        return ResponseEntity.ok(binanceService.save(dto));
    }
}
