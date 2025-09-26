package com.example.restaurant_service.services;

import com.example.restaurant_service.dto.requestDTOs.MenuCreateDTO;
import com.example.restaurant_service.dto.responseDTOs.MenuResponseDTO;
import com.example.restaurant_service.models.MenuModel;

import java.util.ArrayList;

public interface MenuService {
    ArrayList<MenuResponseDTO> getByRestaurant(String id);
    ArrayList<MenuResponseDTO> getByRestaurantCategory(String res_id, String cat_id);
    MenuResponseDTO addMenu(MenuCreateDTO menu);
}
