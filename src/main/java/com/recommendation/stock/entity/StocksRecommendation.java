package com.recommendation.stock.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "StocksRecommendation")
@Builder
@Table(name="stocks_recommendation")
public class StocksRecommendation {

    @Id
    @Column(name="id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="share_name")
    private String shareName;

    @ManyToOne
    @JoinColumn(name = "adviser_id")
    private Adviser adviser;

    @Column(name="entry_price")
    private Double entryPrice;

    @Column(name="recommendation_date_time")
    private Timestamp recommendationDateTime;

    @Column(name="target_price")
    private Double targetPrice;

    @Column(name="stoploss")
    private String stoploss;

    @Column(name="time_period")
    private String timePeriod;

    @Column(name="recommendation_reason")
    private String recommendationReason;

    @Column(name="current_price")
    private Double currentPrice;

    @Column(name="nse_id")
    private String nseId;

    @Column(name="bse_id")
    private String bseId;

    @Column(name="source_link")
    private String sourceLink;

    @Column(name="status")
    private String status;

    @Column(name="close_time")
    private Timestamp closeTime;

    @Column(name="profit")
    private Double profit;

}
