package com.example.restaurant_service.services.impl;

import com.example.restaurant_service.models.CategoryModel;
import com.example.restaurant_service.repositories.CategoryRepository;
import com.example.restaurant_service.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CategoryService_Impl implements CategoryService {

    @Autowired
    private CategoryRepository repo;

    @Override
    public CategoryModel getByRestaurant(String id){
        try{
            return repo.getByRestaurantId(UUID.fromString(id));
        }
        catch (Exception ex){
            return null;
        }
    }
}
