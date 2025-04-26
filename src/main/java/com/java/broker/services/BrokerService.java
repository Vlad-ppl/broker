package com.java.broker.services;

public interface BrokerService {
    String getAccountInfo(String email);

    String getAccountBalance(String email);
}
