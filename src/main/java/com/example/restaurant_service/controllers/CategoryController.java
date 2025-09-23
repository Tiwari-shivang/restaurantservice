package com.example.restaurant_service.controllers;

import com.example.restaurant_service.dto.requestDTOs.CategoryCreateDTO;
import com.example.restaurant_service.dto.responseDTOs.CategoryResponseDTO;
import com.example.restaurant_service.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService service;

    @PostMapping
    public ResponseEntity<?> addCategory(@RequestBody CategoryCreateDTO category){
        CategoryResponseDTO response = service.addCategory(category);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<?> getCategory(@RequestParam(required = false) String id){
        if(id != null){
            ArrayList<CategoryResponseDTO> response = service.getByRestaurant(id);
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.ok("Route working");
    }

    @PutMapping
    public ResponseEntity<?> updateCategory(){
        return ResponseEntity.ok("Route working");
    }

    @DeleteMapping
    public ResponseEntity<?> deleteCategory(){
        return ResponseEntity.ok("Route working");
    }
}
