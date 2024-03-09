package com.example.flowerShop.dto.mappers;

import com.example.flowerShop.dto.product.ProductDTO;
import com.example.flowerShop.dto.product.ProductDetailedDTO;
import com.example.flowerShop.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper implements Mapper<Product, ProductDetailedDTO, ProductDTO> {

    @Override
    public ProductDTO convertToDTO(Product product) {

        if (product != null) {
            return ProductDTO.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .price(product.getPrice())
                    .stock(product.getStock())
                    .category(product.getCategory())
                    .build();
        }
        return null;
    }

    @Override
    public Product convertToEntity(ProductDetailedDTO productDetailedDTO) {

        if (productDetailedDTO != null) {
            return Product.builder()
                    .id(productDetailedDTO.getId())
                    .name(productDetailedDTO.getName())
                    .description(productDetailedDTO.getDescription())
                    .price(productDetailedDTO.getPrice())
                    .stock(productDetailedDTO.getStock())
                    .category(productDetailedDTO.getCategory())
                    .build();
        }
        return null;
    }
}
