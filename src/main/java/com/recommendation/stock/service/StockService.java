package com.recommendation.stock.service;

import lombok.extern.java.Log;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import org.jsoup.*;
import org.jsoup.nodes.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class StockService {

    private static final Logger log = LoggerFactory.getLogger(StockService.class);

    public String getNSEInfyStockCurrentValue(String nseId) throws IOException {
        Document doc = Jsoup
                .connect("https://www.google.com/finance/quote/"+nseId+":NSE")
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36")
                .get();

        Elements parentDiv = doc.getElementsByClass("eYanAe");

// Access the 3rd child of the parent div (0-based index, so 2 is the third child)
        log.info("asdfg"+parentDiv.size());
        TextNode thirdChild = (TextNode) parentDiv.get(0)
                .childNodes().get(2)
                .childNodes().get(1)
                .childNodes().get(0);

// Find the element inside the third child with the class 'P6K39c'
        /*Elements divs = thirdChild.getElementsByClass("P6K39c");*/
      //  Elements divs = doc.getElementsByClass("P6K39c").;
        return thirdChild.text();
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
