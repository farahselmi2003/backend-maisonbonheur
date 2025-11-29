package com.maisonbonheur.perfumebackend.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AddressRequest {
    @NotBlank(message = "La rue est obligatoire")
    private String street;
    
    @NotBlank(message = "La ville est obligatoire")
    private String city;
    
    @NotBlank(message = "Le code postal est obligatoire")
    private String postalCode;
    
    private Boolean isDefault = false;
}