package com.maisonbonheur.perfumebackend.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrderRequest {
    @NotNull(message = "L'adresse de livraison est obligatoire")
    private Long shippingAddressId;
    
    @NotBlank(message = "La méthode de paiement est obligatoire")
    private String paymentMethod;
    
    private String notes;
}