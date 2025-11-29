package com.maisonbonheur.perfumebackend.repository;

import com.maisonbonheur.perfumebackend.entity.Order;
import com.maisonbonheur.perfumebackend.entity.User;
import com.maisonbonheur.perfumebackend.entity.enums.OrderStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUser(User user);
    Page<Order> findByUser(User user, Pageable pageable);
    List<Order> findByStatus(OrderStatus status);
    Long countByUser(User user);
}