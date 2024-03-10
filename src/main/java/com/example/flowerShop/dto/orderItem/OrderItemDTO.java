package com.example.flowerShop.dto.orderItem;

import com.example.flowerShop.entity.Order;
import com.example.flowerShop.entity.Product;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public class OrderItemDTO {

    private UUID id;
    private Long quantity;
    private Product product;
    private Order order;
}
