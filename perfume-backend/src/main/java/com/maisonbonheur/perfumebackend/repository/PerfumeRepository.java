package com.maisonbonheur.perfumebackend.repository;

import com.maisonbonheur.perfumebackend.entity.Perfume;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerfumeRepository extends JpaRepository<Perfume, Long>, JpaSpecificationExecutor<Perfume> {
    List<Perfume> findByIsFeaturedTrue();
    Page<Perfume> findByNameContainingIgnoreCaseOrBrandContainingIgnoreCase(String name, String brand, Pageable pageable);
    
    @Query("SELECT p FROM Perfume p WHERE p.category.id = :categoryId")
    Page<Perfume> findByCategoryId(@Param("categoryId") Long categoryId, Pageable pageable);
    
    @Query("SELECT p FROM Perfume p WHERE p.price BETWEEN :minPrice AND :maxPrice")
    Page<Perfume> findByPriceRange(@Param("minPrice") Double minPrice, @Param("maxPrice") Double maxPrice, Pageable pageable);
    
    List<Perfume> findByRatingGreaterThanEqual(Double minRating);
}