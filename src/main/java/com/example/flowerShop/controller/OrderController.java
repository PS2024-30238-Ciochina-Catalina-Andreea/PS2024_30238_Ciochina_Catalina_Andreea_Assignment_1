package com.example.flowerShop.controller;

import com.example.flowerShop.dto.order.OrderDTO;
import com.example.flowerShop.dto.order.OrderDetailedDTO;
import com.example.flowerShop.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/order")
@CrossOrigin("*")
public class OrderController {

    private final OrderServiceImpl orderServiceImpl;

    @Autowired
    public OrderController(OrderServiceImpl orderServiceImpl) {
        this.orderServiceImpl = orderServiceImpl;
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        return this.orderServiceImpl.getAllOrders();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable UUID id) {
        return this.orderServiceImpl.getOrderById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addOrder(@RequestBody OrderDetailedDTO orderDetailedDTO) {
        return this.orderServiceImpl.addOrder(orderDetailedDTO);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateOrderById(@PathVariable UUID id, @RequestBody OrderDetailedDTO orderDetailedDTO) {
        return this.orderServiceImpl.updateOrderById(id, orderDetailedDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteOrderById(@PathVariable UUID id) {
        return this.orderServiceImpl.deleteOrderById(id);
    }
}
