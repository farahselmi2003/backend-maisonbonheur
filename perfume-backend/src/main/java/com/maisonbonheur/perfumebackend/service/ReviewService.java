package com.maisonbonheur.perfumebackend.service;

import com.maisonbonheur.perfumebackend.entity.Review;
import com.maisonbonheur.perfumebackend.dto.ReviewRequest;
import java.util.List;

public interface ReviewService {
    Review createReview(ReviewRequest reviewRequest, Long userId);
    List<Review> getReviewsByPerfumeId(Long perfumeId);
    List<Review> getReviewsByUserId(Long userId);
    Review updateReview(Long reviewId, ReviewRequest reviewRequest, Long userId);
    void deleteReview(Long reviewId, Long userId);
    Double getAverageRatingByPerfumeId(Long perfumeId);
    Boolean hasUserReviewedPerfume(Long userId, Long perfumeId);
}