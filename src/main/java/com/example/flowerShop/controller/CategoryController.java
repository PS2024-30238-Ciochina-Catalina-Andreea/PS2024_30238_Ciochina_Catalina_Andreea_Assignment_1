package com.example.flowerShop.controller;

import com.example.flowerShop.dto.category.CategoryDTO;
import com.example.flowerShop.dto.category.CategoryDetailedDTO;
import com.example.flowerShop.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {

    private final CategoryServiceImpl categoryServiceImpl;

    @Autowired
    public CategoryController(CategoryServiceImpl categoryServiceImpl) {
        this.categoryServiceImpl = categoryServiceImpl;
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        return this.categoryServiceImpl.getAllCategories();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable UUID id) {
        return this.categoryServiceImpl.getCategoryById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addCategory(@RequestBody CategoryDetailedDTO categoryDetailedDTO) {
        return this.categoryServiceImpl.addCategory(categoryDetailedDTO);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateCategoryById(@PathVariable UUID id, @RequestBody CategoryDetailedDTO categoryDetailedDTO) {
        return this.categoryServiceImpl.updateCategoryById(id, categoryDetailedDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCategoryById(@PathVariable UUID id) {
        return this.categoryServiceImpl.deleteCategoryById(id);
    }
}
