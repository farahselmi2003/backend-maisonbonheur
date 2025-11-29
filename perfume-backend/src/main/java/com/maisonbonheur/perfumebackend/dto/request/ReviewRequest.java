package com.maisonbonheur.perfumebackend.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ReviewRequest {
    @NotNull(message = "L'ID du parfum est obligatoire")
    private Long perfumeId;
    
    @NotNull(message = "La note est obligatoire")
    @Min(value = 1, message = "La note doit être au moins 1")
    @Max(value = 5, message = "La note doit être au maximum 5")
    private Integer rating;
    
    @Size(max = 500, message = "Le commentaire ne doit pas dépasser 500 caractères")
    private String comment;
}