package com.portfolio.recommendation;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RecommendationService {

    private final RecommendationRepository recommendationRepository;

    public RecommendationService(RecommendationRepository recommendationRepository) {
        this.recommendationRepository = recommendationRepository;
    }

    public Recommendation create(Recommendation recommendation) {
        recommendation.setCreatedAt(LocalDateTime.now());
        return recommendationRepository.save(recommendation);
    }

    public List<Recommendation> findAll() {
        return recommendationRepository.findAllByOrderByCreatedAtDesc();
    }
}
