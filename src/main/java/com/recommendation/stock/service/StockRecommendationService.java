package com.recommendation.stock.service;

import com.recommendation.stock.dto.StocksRecommendationDto;
import com.recommendation.stock.entity.Adviser;
import com.recommendation.stock.entity.StocksRecommendation;
import com.recommendation.stock.repository.StocksRecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class StockRecommendationService {
    @Autowired
    private StocksRecommendationRepository stocksRecommendationRepository;

    @Autowired
    private AdviserService adviserService;

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public StocksRecommendation saveOrUpdateRecommendation(StocksRecommendationDto stocksRecommendationDto) {
        Adviser adviser = adviserService.getAdviserById(stocksRecommendationDto.getAdviserId());
        if (adviser == null) {
            return null;
        } else {
            StocksRecommendation stocksRecommendation = convertStockRecommendationDtoToEntity(stocksRecommendationDto);
            stocksRecommendation.setAdviser(adviser);
            return stocksRecommendationRepository.save(stocksRecommendation);
        }
    }

    public List<StocksRecommendationDto> getAllRecommendationByAdvisor(Long adviserId) {
        Adviser adviser = new Adviser();
        adviser.setId(adviserId);
        List<StocksRecommendation> stocksRecommendations = stocksRecommendationRepository.findByAdviser(adviser);
        stocksRecommendations.forEach(stocksRecommendation ->{
            if(stocksRecommendation.getStatus() == null){

            }
        });
        List<StocksRecommendationDto> stocksRecommendationDtos = new ArrayList<>();
        stocksRecommendations.forEach(stocksRecommendation -> stocksRecommendationDtos.add(convertStockRecommendationEntityToDto(stocksRecommendation)));
        return stocksRecommendationDtos;
    }

    private StocksRecommendationDto convertStockRecommendationEntityToDto(StocksRecommendation stocksRecommendation) {
        if (stocksRecommendation != null) {
            StocksRecommendationDto stocksRecommendationDto = new StocksRecommendationDto();
            stocksRecommendationDto.setId(stocksRecommendation.getId());
            stocksRecommendationDto.setRecommendationReason(stocksRecommendation.getRecommendationReason());
            stocksRecommendationDto.setAdviserId(stocksRecommendation.getAdviser().getId());
            stocksRecommendationDto.setAdviserName(stocksRecommendation.getAdviser().getName());
            stocksRecommendationDto.setEntryPrice(stocksRecommendation.getEntryPrice());
            stocksRecommendationDto.setCurrentPrice(stocksRecommendation.getCurrentPrice());
            stocksRecommendationDto.setStoploss(stocksRecommendation.getStoploss());
            stocksRecommendationDto.setShareName(stocksRecommendation.getShareName());
            stocksRecommendationDto.setTargetPrice(stocksRecommendation.getTargetPrice());
            stocksRecommendationDto.setTimePeriod(stocksRecommendation.getTimePeriod());
            stocksRecommendationDto.setBseId(stocksRecommendation.getBseId());
            stocksRecommendationDto.setNseId(stocksRecommendation.getNseId());
            stocksRecommendationDto.setSourceLink(stocksRecommendation.getSourceLink());
            if (stocksRecommendation.getRecommendationDateTime() != null) {
                Date date = new Date();
                date.setTime(stocksRecommendation.getRecommendationDateTime().getTime());
                stocksRecommendationDto.setRecommendationDateTime(dateFormat.format(date));
            }
            if (stocksRecommendation.getCloseTime() != null) {
                Date date = new Date();
                date.setTime(stocksRecommendation.getCloseTime().getTime());
                stocksRecommendationDto.setCloseTime(dateFormat.format(date));
            }
            stocksRecommendationDto.setStatus(stocksRecommendation.getStatus());
            stocksRecommendationDto.setProfit(stocksRecommendation.getProfit());

            return stocksRecommendationDto;
        }
        return null;
    }

    private StocksRecommendation convertStockRecommendationDtoToEntity(StocksRecommendationDto stocksRecommendationDto) {
        if (stocksRecommendationDto != null) {
            StocksRecommendation stocksRecommendation = new StocksRecommendation();

            stocksRecommendation.setId(stocksRecommendationDto.getId());
            stocksRecommendation.setRecommendationReason(stocksRecommendationDto.getRecommendationReason());
            stocksRecommendation.setEntryPrice(stocksRecommendationDto.getEntryPrice());
            stocksRecommendation.setCurrentPrice(stocksRecommendationDto.getCurrentPrice());
            stocksRecommendation.setStoploss(stocksRecommendationDto.getStoploss());
            stocksRecommendation.setShareName(stocksRecommendationDto.getShareName());
            stocksRecommendation.setTargetPrice(stocksRecommendationDto.getTargetPrice());
            stocksRecommendation.setTimePeriod(stocksRecommendationDto.getTimePeriod());
            stocksRecommendation.setBseId(stocksRecommendationDto.getBseId());
            stocksRecommendation.setNseId(stocksRecommendationDto.getNseId());
            stocksRecommendation.setSourceLink(stocksRecommendationDto.getSourceLink());
            if (stocksRecommendationDto.getRecommendationDateTime() != null
                    && !stocksRecommendationDto.getRecommendationDateTime().trim().equalsIgnoreCase("")) {
                Date parsedDate = null;
                try {
                    parsedDate = dateFormat.parse(stocksRecommendationDto.getRecommendationDateTime());
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                stocksRecommendation.setRecommendationDateTime(new Timestamp(parsedDate.getTime()));
            }
            return stocksRecommendation;
        }
        return null;
    }
}
