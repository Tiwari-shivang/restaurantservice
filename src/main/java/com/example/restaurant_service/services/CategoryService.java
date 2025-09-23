package com.example.restaurant_service.services;

import com.example.restaurant_service.dto.requestDTOs.CategoryCreateDTO;
import com.example.restaurant_service.dto.responseDTOs.CategoryResponseDTO;
import com.example.restaurant_service.models.CategoryModel;

import java.util.ArrayList;

public interface CategoryService {
    ArrayList<CategoryResponseDTO> getByRestaurant(String id);
    CategoryResponseDTO addCategory(CategoryCreateDTO category);
}
