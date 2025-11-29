package com.maisonbonheur.perfumebackend.controller;

import com.maisonbonheur.perfumebackend.entity.Perfume;
import com.maisonbonheur.perfumebackend.service.PerfumeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/perfumes")
@RequiredArgsConstructor
@Tag(name = "Perfumes", description = "Gestion des parfums")
public class PerfumeController {
    
    private final PerfumeService perfumeService;
    
    @GetMapping
    @Operation(summary = "Liste tous les parfums avec pagination et filtres")
    public ResponseEntity<Page<Perfume>> getAllPerfumes(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "12") int size,
            @RequestParam(required = false) Long categoryId,
            @RequestParam(required = false) BigDecimal minPrice,
            @RequestParam(required = false) BigDecimal maxPrice,
            @RequestParam(required = false) Double minRating,
            @RequestParam(required = false) String intensity,
            @RequestParam(required = false) String season,
            @RequestParam(required = false) String sortBy,
            @RequestParam(required = false) String sortDirection) {
        
        Pageable pageable = PageRequest.of(page, size);
        
        if (sortBy != null) {
            Sort sort = Sort.by(sortDirection != null && sortDirection.equalsIgnoreCase("desc") 
                ? Sort.Direction.DESC : Sort.Direction.ASC, sortBy);
            pageable = PageRequest.of(page, size, sort);
        }
        
        return ResponseEntity.ok(perfumeService.findWithFilters(
            categoryId, minPrice, maxPrice, minRating, intensity, season, pageable));
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Trouve un parfum par son ID")
    public ResponseEntity<Perfume> getPerfumeById(@PathVariable Long id) {
        return ResponseEntity.ok(perfumeService.findById(id));
    }
    
    @GetMapping("/featured")
    @Operation(summary = "Liste les parfums en vedette")
    public ResponseEntity<List<Perfume>> getFeaturedPerfumes() {
        return ResponseEntity.ok(perfumeService.findFeaturedPerfumes());
    }
    
    @GetMapping("/search")
    @Operation(summary = "Recherche de parfums par nom ou marque")
    public ResponseEntity<Page<Perfume>> searchPerfumes(
            @RequestParam String query,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "12") int size) {
        
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(perfumeService.searchPerfumes(query, pageable));
    }
}