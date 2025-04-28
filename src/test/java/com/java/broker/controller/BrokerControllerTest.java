package com.java.broker.controller;

import com.java.broker.services.BrokerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BrokerController.class)
@ExtendWith(SpringExtension.class)
public class BrokerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BrokerService brokerService;


    @Test
    @DisplayName("GET /api/broker/account should return account info")
    void getAccountInfo_ShouldReturnAccountInfo() throws Exception {

        String email = "test@example.com";
        String expectedResponse = "{\"data\":\"Normal\"}";

        when(brokerService.getAccountInfo(email)).thenReturn(expectedResponse);

        mockMvc.perform(get("/api/broker/account")
                        .param("email", email))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedResponse));
    }

    @Test
    @DisplayName("GET /api/broker/balance should return account balance")
    void getBalance_ShouldReturnBalance() throws Exception {

        String email = "test@example.com";
        String expectedBalance = "{\"BTC\":\"0.01\",\"USDT\":\"25.00\"}";

        when(brokerService.getAccountBalance(email)).thenReturn(expectedBalance);

        mockMvc.perform(get("/api/broker/balance")
                        .param("email", email))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedBalance));
    }

}
