package com.java.broker.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BinanceDto {

    private String apiKey;
    private String secretKey;
    private Long userId;
}
