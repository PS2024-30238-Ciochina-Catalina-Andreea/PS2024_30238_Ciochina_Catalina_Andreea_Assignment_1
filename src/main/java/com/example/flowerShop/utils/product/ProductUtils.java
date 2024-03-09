package com.example.flowerShop.utils.product;

import com.example.flowerShop.dto.product.ProductDetailedDTO;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@NoArgsConstructor
public class ProductUtils {

    public boolean validateProductMap(ProductDetailedDTO productDetailedDTO) {
        return !Objects.equals(productDetailedDTO.getName(), "")
                && !Objects.equals(productDetailedDTO.getStock(),null )
                && !Objects.equals(productDetailedDTO.getCategory(), null)
                && !Objects.equals(productDetailedDTO.getPrice(), null)
                && !Objects.equals(productDetailedDTO.getDescription(), "");
    }
}
