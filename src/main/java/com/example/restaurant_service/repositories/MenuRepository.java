package com.example.restaurant_service.repositories;

import com.example.restaurant_service.dto.responseDTOs.MenuResponseDTO;
import com.example.restaurant_service.models.CategoryModel;
import com.example.restaurant_service.models.MenuModel;
import com.example.restaurant_service.models.RestaurantModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.UUID;

public interface MenuRepository extends JpaRepository<MenuModel, UUID> {
    ArrayList<MenuModel> getByRestaurantId(UUID id);
    ArrayList<MenuModel> getByRestaurantAndCategory(RestaurantModel restaurant, CategoryModel category);
}