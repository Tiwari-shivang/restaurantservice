package com.example.restaurant_service.services.impl;

import com.example.restaurant_service.models.MenuModel;
import com.example.restaurant_service.repositories.MenuRepository;
import com.example.restaurant_service.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MenuService_Impl implements MenuService {

    @Autowired
    private MenuRepository repo;
    @Override
    public MenuModel getByRestaurant(String id){
        try{
            return repo.getByRestaurantId(UUID.fromString(id));
        }
        catch (Exception ex){
            return null;
        }
    }
}
