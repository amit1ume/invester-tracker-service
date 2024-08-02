package com.recommendation.stock.repository;

import com.recommendation.stock.entity.Adviser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdviserRepository extends JpaRepository<Adviser, Long> {
}
