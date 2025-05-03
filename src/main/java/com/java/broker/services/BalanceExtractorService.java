package com.java.broker.services;

import org.json.JSONArray;
import org.json.JSONObject;

public interface BalanceExtractorService {
    JSONObject extractBalance(JSONArray balances);
}
