package com.example.flowerShop.service.impl;

import com.example.flowerShop.dto.order.OrderDTO;
import com.example.flowerShop.dto.order.OrderDetailedDTO;
import com.example.flowerShop.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        return null;
    }

    @Override
    public ResponseEntity<OrderDTO> getOrderById(UUID id) {
        return null;
    }

    @Override
    public ResponseEntity<String> addOrder(OrderDetailedDTO orderDetailedDTO) {
        return null;
    }

    @Override
    public ResponseEntity<String> updateOrderById(UUID id, OrderDetailedDTO orderDetailedDTO) {
        return null;
    }

    @Override
    public ResponseEntity<String> deleteOrderById(UUID id) {
        return null;
    }
}
