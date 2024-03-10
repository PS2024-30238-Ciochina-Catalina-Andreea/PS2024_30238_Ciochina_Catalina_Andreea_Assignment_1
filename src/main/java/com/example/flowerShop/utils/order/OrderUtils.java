package com.example.flowerShop.utils.order;

import com.example.flowerShop.dto.order.OrderDetailedDTO;
import com.example.flowerShop.dto.orderItem.OrderItemDetailedDTO;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@NoArgsConstructor
public class OrderUtils {

    public boolean validateOrderMap(OrderDetailedDTO orderDetailedDTO) {
        return  orderDetailedDTO.getId_user() != null
                && orderDetailedDTO.getId_orderItems() != null
                && !orderDetailedDTO.getId_orderItems().isEmpty();
    }
}
