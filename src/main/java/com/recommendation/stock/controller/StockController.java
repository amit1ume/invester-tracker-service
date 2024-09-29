package com.recommendation.stock.controller;

import com.recommendation.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping({"nse", "/nse/{id}"})
    public String getNSEInfyStockValue(@PathVariable String id) throws IOException {
        return stockService.getNSEInfyStockCurrentValue(id);
    }

    @GetMapping({"bom", "/bom"})
    public String getBOMInfyStockValue() throws IOException {
        return stockService.getBOMInfyStockCurrentValue();
    }

    @GetMapping({"nse", "/nse/range/{id}"})
    public String getNSEStockDayRangeValue(@PathVariable String id) throws IOException {
        return stockService.getNSEStockDayRangeValue(id);
    }
}
