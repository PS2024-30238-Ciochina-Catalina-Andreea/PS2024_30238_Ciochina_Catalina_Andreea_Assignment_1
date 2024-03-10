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

    /**
     * Dep injection in constructor by using Autowired annotation
     * @param orderItemServiceImpl
     */
    @Autowired
    public OrderItemController(OrderItemServiceImpl orderItemServiceImpl) {
        this.orderItemServiceImpl = orderItemServiceImpl;
    }

    /**
     * Gets list of all order items
     * @return ResponseEntity<List<OrderItemDTO>>
     */
    @GetMapping("/get/all")
    public ResponseEntity<List<OrderItemDTO>> getAllOrderItems() {
        return this.orderItemServiceImpl.getAllOrderItems();
    }

    /**
     * Gets order item by id
     * @param id
     * @return ResponseEntity<OrderItemDTO>
     */
    @GetMapping("/get/{id}")
    public ResponseEntity<OrderItemDTO> getOrderItemById(@PathVariable UUID id) {
        return this.orderItemServiceImpl.getOrderItemById(id);
    }

    /**
     * Creates a new order item
     * @param orderItemDetailedDTO
     * @return ResponseEntity<String>
     */
    @PostMapping("/add")
    public ResponseEntity<String> addOrderItem(@RequestBody OrderItemDetailedDTO orderItemDetailedDTO) {
        return this.orderItemServiceImpl.addOrderItem(orderItemDetailedDTO);
    }

    /**
     * Updates an existing order item given by id
     * @param id
     * @param orderItemDetailedDTO
     * @return ResponseEntity<String>
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateOrderItemById(@PathVariable UUID id, @RequestBody OrderItemDetailedDTO orderItemDetailedDTO) {
        return this.orderItemServiceImpl.updateOrderItemById(id, orderItemDetailedDTO);
    }

    /**
     * Deletes an existing item given by id
     * @param id
     * @return ResponseEntity<String>
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteOrderItemById(@PathVariable UUID id) {
        return this.orderItemServiceImpl.deleteOrderItemById(id);
    }
}
