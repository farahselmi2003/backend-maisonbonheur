package com.maisonbonheur.perfumebackend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PerfumeResponse {
    private Long id;
    private String name;
    private String brand;
    private BigDecimal price;
    private Double rating;
    private String imageUrl;
    private String intensity;
    private String season;
    private String mood;
    private Boolean isFeatured;
    private String description;
    private Boolean inStock;
    private CategoryResponse category;
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class CategoryResponse {
    private Long id;
    private String name;
    private String description;
    private String imageUrl;
}