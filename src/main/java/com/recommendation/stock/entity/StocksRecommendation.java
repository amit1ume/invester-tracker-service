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

    @Column(name="shareName")
    private String shareName;

    @ManyToOne
    @JoinColumn(name = "adviserId")
    private Adviser adviser;

    @Column(name="entryPrice")
    private Double entryPrice;

    @Column(name="recommendationDateTime")
    private Timestamp recommendationDateTime;

    @Column(name="targetPrice")
    private Double targetPrice;

    @Column(name="stoploss")
    private String stoploss;

    @Column(name="timePeriod")
    private String timePeriod;

    @Column(name="recommendationReason")
    private String recommendationReason;

    @Column(name="currentPrice")
    private Double currentPrice;

    @Column(name="nseId")
    private String nseId;

    @Column(name="bseId")
    private String bseId;

    @Column(name="sourceLink")
    private String sourceLink;

}
