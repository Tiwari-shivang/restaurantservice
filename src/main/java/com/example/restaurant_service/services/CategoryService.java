package com.example.restaurant_service.services;

import com.example.restaurant_service.models.CategoryModel;

public interface CategoryService {
    CategoryModel getByRestaurant(String id);
}
