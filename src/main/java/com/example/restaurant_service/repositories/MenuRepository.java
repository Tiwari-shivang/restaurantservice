package com.example.restaurant_service.repositories;

import com.example.restaurant_service.models.MenuModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MenuRepository extends JpaRepository<MenuModel, UUID> {
    MenuModel getByRestaurantId(UUID id);
}
