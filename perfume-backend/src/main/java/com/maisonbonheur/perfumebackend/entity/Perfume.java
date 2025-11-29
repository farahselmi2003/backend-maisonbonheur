package com.maisonbonheur.perfumebackend.entity;

import com.maisonbonheur.perfumebackend.entity.enums.Intensity;
import com.maisonbonheur.perfumebackend.entity.enums.Mood;
import com.maisonbonheur.perfumebackend.entity.enums.Season;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Table(name = "perfumes")
@Data
public class Perfume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String brand;
    
    @Column(nullable = false)
    private BigDecimal price;
    
    private Double rating;
    
    @Column(name = "image_url")
    private String imageUrl;
    
    @Enumerated(EnumType.STRING)
    private Intensity intensity;
    
    @Enumerated(EnumType.STRING)
    private Season season;
    
    @Enumerated(EnumType.STRING)
    private Mood mood;
    
    @Column(name = "is_featured")
    private Boolean isFeatured;
    
    @Column(length = 1000)
    private String description;
    
    @Column(name = "in_stock")
    private Boolean inStock;
    
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}