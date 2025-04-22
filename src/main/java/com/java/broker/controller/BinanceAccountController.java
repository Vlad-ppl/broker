package com.java.broker.controller;

import com.java.broker.services.BinanceBalanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/binance")
@RequiredArgsConstructor
public class BinanceAccountController {

    private final BinanceBalanceService binanceAccountService;


    @GetMapping("/balance")
    public ResponseEntity<String> getBalance(@RequestParam String email) {
        return ResponseEntity.ok(binanceAccountService.getAccountBalanceByEmail(email));
    }

    @GetMapping("/usdt")
    public ResponseEntity<String> getUsdtBalance(@RequestParam String email) {
        return ResponseEntity.ok(binanceAccountService.getUsdtBalance(email));
    }

    @GetMapping("/btc")
    public ResponseEntity<String> getBtcBalance(@RequestParam String email) {
        return ResponseEntity.ok(binanceAccountService.getBtcBalance(email));
    }
}
