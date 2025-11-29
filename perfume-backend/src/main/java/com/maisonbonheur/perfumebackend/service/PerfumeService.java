package com.maisonbonheur.perfumebackend.service;

import com.maisonbonheur.perfumebackend.entity.Perfume;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;

public interface PerfumeService {
    Page<Perfume> findAll(Pageable pageable);
    Perfume findById(Long id);
    Perfume save(Perfume perfume);
    Perfume update(Long id, Perfume perfume);
    void deleteById(Long id);
    List<Perfume> findFeaturedPerfumes();
    Page<Perfume> findWithFilters(Long categoryId, BigDecimal minPrice, BigDecimal maxPrice, 
                                  Double minRating, String intensity, String season, Pageable pageable);
    Page<Perfume> searchPerfumes(String query, Pageable pageable);
    List<Perfume> findByCategoryId(Long categoryId);
    List<Perfume> findRelatedPerfumes(Long perfumeId, Long categoryId);
}