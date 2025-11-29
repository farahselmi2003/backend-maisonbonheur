package com.maisonbonheur.perfumebackend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewResponse {
    private Long id;
    private Long perfumeId;
    private UserReviewResponse user;
    private Integer rating;
    private String comment;
    private LocalDateTime createdAt;
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class UserReviewResponse {
    private Long id;
    private String firstName;
    private String lastName;
}