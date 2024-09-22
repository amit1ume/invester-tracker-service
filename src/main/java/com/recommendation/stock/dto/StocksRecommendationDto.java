package com.recommendation.stock.dto;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StocksRecommendationDto {

    private Long id;

    private String shareName;

    private Long adviserId;

    @Nullable
    private String adviserName;

    private Double entryPrice;

    private String recommendationDateTime;

    @Nullable
    private Double targetPrice;

    @Nullable
    private String stoploss;

    private String timePeriod;

    private String recommendationReason;

    @Nullable
    private Double currentPrice;

    private String nseId;

    private String bseId;
    private String sourceLink;

    private String status;

    private String closeTime;
    private Double profit;
}
