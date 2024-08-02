package com.recommendation.stock.repository;

import com.recommendation.stock.entity.Adviser;
import com.recommendation.stock.entity.StocksRecommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StocksRecommendationRepository extends JpaRepository<StocksRecommendation, Long> {

    @Query(value = "select * from adviser where adviser=:adv",nativeQuery = true)
    public List<StocksRecommendation> findByAdviser(@Param("adv") Adviser adviser);


}
