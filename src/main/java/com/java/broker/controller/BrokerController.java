package com.java.broker.controller;

import com.java.broker.services.BrokerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/broker")
@RequiredArgsConstructor
public class BrokerController {

    private final BrokerService brokerService;

    @GetMapping("/account")
    public String getAccountInfo(@RequestParam String email) {
        return brokerService.getAccountInfo(email);
    }

    @GetMapping("/balance")
    public String getBalance(@RequestParam String email) {
        return brokerService.getAccountBalance(email);
    }
}
