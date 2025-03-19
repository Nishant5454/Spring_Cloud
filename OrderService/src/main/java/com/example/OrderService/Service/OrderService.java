package com.example.OrderService.Service;

import com.example.OrderService.Entity.OrderEntity;
import com.example.OrderService.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    public OrderEntity createOrder(OrderEntity order) {
        return orderRepository.save(order);
    }

    public List<OrderEntity> getOrderByUserId(Long userId) {
        return orderRepository.findByUserId(userId);
    }
}