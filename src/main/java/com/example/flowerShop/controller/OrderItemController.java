package com.example.flowerShop.controller;

import com.example.flowerShop.dto.orderItem.OrderItemDTO;
import com.example.flowerShop.dto.orderItem.OrderItemDetailedDTO;
import com.example.flowerShop.service.impl.OrderItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/orderItem")
@CrossOrigin("*")
public class OrderItemController {

    private final OrderItemServiceImpl orderItemServiceImpl;

    @Autowired
    public OrderItemController(OrderItemServiceImpl orderItemServiceImpl) {
        this.orderItemServiceImpl = orderItemServiceImpl;
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<OrderItemDTO>> getAllOrderItems() {
        return this.orderItemServiceImpl.getAllOrderItems();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<OrderItemDTO> getOrderItemById(@PathVariable UUID id) {
        return this.orderItemServiceImpl.getOrderItemById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addOrderItem(@RequestBody OrderItemDetailedDTO orderItemDetailedDTO) {
        return this.orderItemServiceImpl.addOrderItem(orderItemDetailedDTO);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateOrderItemById(@PathVariable UUID id, @RequestBody OrderItemDetailedDTO orderItemDetailedDTO) {
        return this.orderItemServiceImpl.updateOrderItemById(id, orderItemDetailedDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteOrderItemById(@PathVariable UUID id) {
        return this.orderItemServiceImpl.deleteOrderItemById(id);
    }
}
