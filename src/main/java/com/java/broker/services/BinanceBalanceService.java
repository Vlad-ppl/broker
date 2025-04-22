package com.java.broker.services;

import com.binance.connector.client.impl.SpotClientImpl;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BinanceBalanceService {

    private final BinanceClientFactory binanceClientFactory;

    public String getAccountBalanceByEmail(String email) {
        SpotClientImpl client = binanceClientFactory.create(email);

        Map<String, Object> params = new HashMap<>();
        return client.createTrade().account(params);
    }

    public String getBtcBalance(String email) {
        SpotClientImpl client = binanceClientFactory.create(email);
        String response = client.createTrade().account(new HashMap<>());

        JSONArray balances = new JSONObject(response).getJSONArray("balances");

        for (int i = 0; i < balances.length(); i++) {
            JSONObject asset = balances.getJSONObject(i);
            if ("BTC".equals(asset.getString("asset"))) {
                return asset.getString("free");
            }
        }

        return "0.0";
    }

    public String getUsdtBalance(String email) {
        SpotClientImpl client = binanceClientFactory.create(email);
        String response = client.createTrade().account(new HashMap<>());

        JSONArray balances = new JSONObject(response).getJSONArray("balances");

        for (int i = 0; i < balances.length(); i++) {
            JSONObject asset = balances.getJSONObject(i);
            if ("USDT".equals(asset.getString("asset"))) {
                return asset.getString("free");
            }
        }

        return "0.0";
    }


}
