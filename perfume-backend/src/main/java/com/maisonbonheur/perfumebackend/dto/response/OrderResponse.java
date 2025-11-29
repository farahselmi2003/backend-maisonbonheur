package com.maisonbonheur.perfumebackend.dto.response;

import com.maisonbonheur.perfumebackend.entity.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {
    private Long id;
    private Long userId;
    private List<OrderItemResponse> items;
    private BigDecimal total;
    private OrderStatus status;
    private AddressResponse shippingAddress;
    private String paymentMethod;
    private LocalDateTime createdAt;
    private LocalDateTime deliveredAt;
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class OrderItemResponse {
    private Long perfumeId;
    private String name;
    private Integer quantity;
    private BigDecimal price;
    private String imageUrl;
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class AddressResponse {
    private String street;
    private String city;
    private String postalCode;
}