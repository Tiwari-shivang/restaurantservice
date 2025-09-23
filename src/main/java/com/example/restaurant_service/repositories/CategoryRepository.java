package com.example.restaurant_service.repositories;

import com.example.restaurant_service.models.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<CategoryModel, UUID> {
    CategoryModel getByRestaurantId(UUID id);
}
