package com.recommendation.stock.service;

import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import org.jsoup.*;
import org.jsoup.nodes.*;

import java.io.IOException;

@Service
public class StockService {

    public String getNSEInfyStockCurrentValue(String nseId) throws IOException {
        Document doc = Jsoup
                .connect("https://www.google.com/finance/quote/"+nseId+":NSE")
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36")
                .get();
        Elements divs = doc.getElementsByClass("YMlKec fxKbKc");
        return divs.text();
    }

    public String getBOMInfyStockCurrentValue() throws IOException {
        Document doc = Jsoup
                .connect("https://www.google.com/finance/quote/500209:BOM")
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36")
                .get();
        Elements divs = doc.getElementsByClass("YMlKec fxKbKc");
        return divs.text();
    }
}
