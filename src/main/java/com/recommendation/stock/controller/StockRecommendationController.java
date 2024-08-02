package com.recommendation.stock.controller;

import com.recommendation.stock.dto.StocksRecommendationDto;
import com.recommendation.stock.entity.StocksRecommendation;
import com.recommendation.stock.service.StockRecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stocks_recommendation")
public class StockRecommendationController {

    @Autowired
    private StockRecommendationService stockRecommendationService;

    @PostMapping(value = { "", "/" }, produces = "application/json")
    public ResponseEntity<StocksRecommendation> saveRecommendation(@RequestBody StocksRecommendationDto stocksRecommendationDto) {
        StocksRecommendation result = stockRecommendationService.saveOrUpdateRecommendation(stocksRecommendationDto);
        if (result != null) {
            return new ResponseEntity<>(result, new HttpHeaders(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = { "{adviserId}", "{adviserId}/" }, produces = "application/json")
    public ResponseEntity<List<StocksRecommendationDto>> getRecommendationByAdviserId(@PathVariable long adviserId) {
        return new ResponseEntity<>(stockRecommendationService.getAllRecommendationByAdvisor(adviserId), new HttpHeaders(), HttpStatus.OK);
    }
}
