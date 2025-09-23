package com.example.restaurant_service.services.impl;

import com.example.restaurant_service.dto.requestDTOs.CategoryCreateDTO;
import com.example.restaurant_service.dto.responseDTOs.CategoryResponseDTO;
import com.example.restaurant_service.models.CategoryModel;
import com.example.restaurant_service.models.RestaurantModel;
import com.example.restaurant_service.repositories.CategoryRepository;
import com.example.restaurant_service.repositories.RestaurantRepo;
import com.example.restaurant_service.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.UUID;

@Service
public class CategoryService_Impl implements CategoryService {

    @Autowired
    private CategoryRepository repo;
    @Autowired
    private RestaurantRepo restaurantRepo;

    @Override
    public ArrayList<CategoryResponseDTO> getByRestaurant(String id){
        try{
            ArrayList<CategoryModel> categories = repo.getByRestaurantId(UUID.fromString(id));
            ArrayList<CategoryResponseDTO> response = new ArrayList<>();
            categories.forEach((category) -> {
                CategoryResponseDTO categoryVal = new CategoryResponseDTO(category.getId().toString(), category.getName(), category.getDescription(), category.getRestaurant().getId().toString(), category.getCreated_at(), category.getUpdated_at());
                response.add(categoryVal);
            });
            return response;
        }
        catch (Exception ex){
            return null;
        }
    }

    @Override
    public CategoryResponseDTO addCategory(CategoryCreateDTO category){
        CategoryModel newCategory = new CategoryModel();
        newCategory.setName(category.getName());
        newCategory.setDescription(category.getDescription());
        newCategory.setCreated_at(Timestamp.from(Instant.now()));
        newCategory.setUpdated_at(Timestamp.from(Instant.now()));
        RestaurantModel restaurant = restaurantRepo.findById(UUID.fromString(category.getRestaurant())).orElseThrow(() -> new RuntimeException(("Restaurant not found")));
        newCategory.setRestaurant(restaurant);
        CategoryModel createdCategory = repo.save(newCategory);
        return new CategoryResponseDTO(createdCategory.getId().toString(), createdCategory.getName(), createdCategory.getDescription(), restaurant.getId().toString(), createdCategory.getCreated_at(), createdCategory.getUpdated_at());
    }
}
