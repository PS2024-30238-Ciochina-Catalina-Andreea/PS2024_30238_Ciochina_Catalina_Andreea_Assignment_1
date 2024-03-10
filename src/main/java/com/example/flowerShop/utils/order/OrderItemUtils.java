package com.example.flowerShop.utils.order;

import com.example.flowerShop.dto.category.CategoryDetailedDTO;
import com.example.flowerShop.dto.orderItem.OrderItemDTO;
import com.example.flowerShop.dto.orderItem.OrderItemDetailedDTO;
import com.example.flowerShop.entity.Category;
import com.example.flowerShop.entity.OrderItem;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@NoArgsConstructor
public class OrderItemUtils {

    public boolean validateOrderItemMap(OrderItemDetailedDTO orderItemDetailedDTO) {
        return !Objects.equals(orderItemDetailedDTO.getQuantity(), null)
                && !Objects.equals(orderItemDetailedDTO.getId_product(), "");
    }

    public static void updateCategoryValues(OrderItem orderItemExisting, OrderItemDTO orderItemDTO) {
        if (Objects.nonNull(orderItemExisting.getProduct())) {
            orderItemExisting.setProduct(orderItemDTO.getProduct());
        }
        if (Objects.nonNull(orderItemExisting.getQuantity())) {
            orderItemExisting.setQuantity(orderItemDTO.getQuantity());
        }
    }
}
