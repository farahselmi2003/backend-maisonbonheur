package com.maisonbonheur.perfumebackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(length = 500)
    private String description;
    
    @Column(name = "image_url")
    private String imageUrl;
    
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Perfume> perfumes = new ArrayList<>();
}