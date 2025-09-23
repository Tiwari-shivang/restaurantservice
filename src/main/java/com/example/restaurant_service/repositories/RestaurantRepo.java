package com.example.restaurant_service.repositories;

import com.example.restaurant_service.models.RestaurantModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RestaurantRepo extends JpaRepository<RestaurantModel, UUID> {
}
