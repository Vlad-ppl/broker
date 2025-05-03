package com.java.broker.services.impl;

import com.java.broker.services.BalanceExtractorService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class BinanceBalanceExtractorService implements BalanceExtractorService {

    private static final Set<String> SUPPORTED_ACCOUNTS = Set.of("BTC", "USDT");

    @Override
    public JSONObject extractBalance(JSONArray balances) {
        JSONObject result = new JSONObject();

        for(int i = 0; i < balances.length(); i++) {
            JSONObject balance = balances.getJSONObject(i);
            String symbol = balance.getString("asset");
            String free = balance.getString("free");

            if (SUPPORTED_ACCOUNTS.contains(symbol)) {
                result.put("asset", free);
            }
        }
        return result;
    }
}
