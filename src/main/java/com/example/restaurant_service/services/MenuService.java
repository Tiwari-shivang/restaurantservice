package com.example.restaurant_service.services;

import com.example.restaurant_service.models.MenuModel;

public interface MenuService {
    MenuModel getByRestaurant(String id);
}
