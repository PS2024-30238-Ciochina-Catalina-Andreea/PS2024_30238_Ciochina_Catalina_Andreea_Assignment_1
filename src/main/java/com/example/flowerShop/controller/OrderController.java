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

    /**
     * Constructor with injection
     * @param orderServiceImpl
     */
    @Autowired
    public OrderController(OrderServiceImpl orderServiceImpl) {
        this.orderServiceImpl = orderServiceImpl;
    }

    /**
     * Gets list of orders
     * @return ResponseEntity<List<OrderDTO>>
     */
    @GetMapping("/get/all")
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        return this.orderServiceImpl.getAllOrders();
    }

    /**
     * Retrieves order by given id
     * @param id
     * @return ResponseEntity<OrderDTO>
     */
    @GetMapping("/get/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable UUID id) {
        return this.orderServiceImpl.getOrderById(id);
    }

    /**
     * Creates a new order
     * @param orderDetailedDTO
     * @return ResponseEntity<String>
     */
    @PostMapping("/add")
    public ResponseEntity<String> addOrder(@RequestBody OrderDetailedDTO orderDetailedDTO) {
        return this.orderServiceImpl.addOrder(orderDetailedDTO);
    }

    /**
     * Updates an existing order searched by id
     * @param id
     * @param orderDetailedDTO
     * @return ResponseEntity<String>
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateOrderById(@PathVariable UUID id, @RequestBody OrderDetailedDTO orderDetailedDTO) {
        return this.orderServiceImpl.updateOrderById(id, orderDetailedDTO);
    }

    /**
     * Deletes an order by id
     * @param id
     * @return ResponseEntity<String>
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteOrderById(@PathVariable UUID id) {
        return this.orderServiceImpl.deleteOrderById(id);
    }
}
