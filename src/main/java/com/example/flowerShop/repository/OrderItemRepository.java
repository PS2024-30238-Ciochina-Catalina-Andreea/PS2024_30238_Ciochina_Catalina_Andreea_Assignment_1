package com.example.flowerShop.repository;

import com.example.flowerShop.entity.OrderItem;
import com.example.flowerShop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, UUID> {

    Optional<OrderItem> findByProductAndQuantity(Product product, Long quantity);

    List<OrderItem> findProjectedByIdIn(List<UUID> orderItemIds);

}
