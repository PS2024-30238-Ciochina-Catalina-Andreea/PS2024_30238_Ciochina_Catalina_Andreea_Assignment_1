package com.example.flowerShop.controller;

import com.example.flowerShop.dto.product.ProductDetailedDTO;
import com.example.flowerShop.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
@CrossOrigin("*")
public class ProductController {

    private final ProductServiceImpl productServiceImpl;

    @Autowired
    public ProductController(ProductServiceImpl productServiceImpl) {
        this.productServiceImpl = productServiceImpl;
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<ProductDetailedDTO>> getAllProducts() {
        return this.productServiceImpl.getAllProducts();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ProductDetailedDTO> getProductById(@PathVariable UUID id) {
        return this.productServiceImpl.getProductById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addProduct(@RequestBody ProductDetailedDTO productDetailedDTO) {
        return this.productServiceImpl.addProduct(productDetailedDTO);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateProductById(@PathVariable UUID id, @RequestBody ProductDetailedDTO productDetailedDTO) {
        return this.productServiceImpl.updateProductById(id, productDetailedDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable UUID id) {
        return this.productServiceImpl.deleteProductById(id);
    }
}
