package com.example.OrderService.Repository;

import com.example.OrderService.Entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity,Long> {
    List<OrderEntity>findByUserId(Long id);
}
