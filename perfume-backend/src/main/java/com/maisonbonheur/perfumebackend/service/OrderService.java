package com.maisonbonheur.perfumebackend.service;

import com.maisonbonheur.perfumebackend.entity.Order;
import com.maisonbonheur.perfumebackend.dto.request.OrderRequest;
import com.maisonbonheur.perfumebackend.dto.response.OrderResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderService {
    Order createOrder(Long userId, OrderRequest orderRequest);
    Order getOrderById(Long id);
    List<Order> getOrdersByUserId(Long userId);
    Page<Order> getOrdersByUserId(Long userId, Pageable pageable);
    List<Order> getAllOrders();
    Order updateOrderStatus(Long orderId, String status);
    OrderResponse getOrderDetails(Long orderId);
    void cancelOrder(Long orderId);
}