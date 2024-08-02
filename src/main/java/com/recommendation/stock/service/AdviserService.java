package com.recommendation.stock.service;

import com.recommendation.stock.entity.Adviser;
import com.recommendation.stock.repository.AdviserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdviserService {

    @Autowired
    private AdviserRepository adviserRepository;

    public Adviser saveOrUpdateAdviser(Adviser adviser) {
        return adviserRepository.save(adviser);
    }

    public Adviser getAdviserById(Long id) {
        Optional<Adviser> adviser = adviserRepository.findById(id);
        if (adviser.isPresent()) {
            return adviser.get();
        }
        return null;
    }

    public List<Adviser> getAllAdvisers() {
        return adviserRepository.findAll();
    }
}
