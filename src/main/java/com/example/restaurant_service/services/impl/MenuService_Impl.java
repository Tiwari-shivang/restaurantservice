package com.example.restaurant_service.services.impl;

import com.example.restaurant_service.dto.requestDTOs.MenuCreateDTO;
import com.example.restaurant_service.dto.responseDTOs.MenuResponseDTO;
import com.example.restaurant_service.models.CategoryModel;
import com.example.restaurant_service.models.MenuModel;
import com.example.restaurant_service.models.RestaurantModel;
import com.example.restaurant_service.repositories.CategoryRepository;
import com.example.restaurant_service.repositories.MenuRepository;
import com.example.restaurant_service.repositories.RestaurantRepo;
import com.example.restaurant_service.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class MenuService_Impl implements MenuService {

    @Autowired
    private MenuRepository repo;
    @Autowired
    private RestaurantRepo restaurantRepo;
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public ArrayList<MenuResponseDTO> getByRestaurant(String id){
        try{
            ArrayList<MenuModel> menus = repo.getByRestaurantId(UUID.fromString(id));
            ArrayList<MenuResponseDTO> restaurantMenus = new ArrayList<>();
            menus.forEach((menu) -> {
                MenuResponseDTO restaurantMenu = new MenuResponseDTO(menu.getId().toString(), menu.getRestaurant().getId().toString(), menu.getCategory().getId().toString(), menu.getName(), menu.getDescription(), menu.getImage_url(), menu.getPrice(), menu.getIs_available(), menu.getCreated_at(), menu.getUpdated_at());
                restaurantMenus.add(restaurantMenu);
            });
            return restaurantMenus;
        }
        catch (Exception ex){
            return null;
        }
    }

    @Override
    public ArrayList<MenuResponseDTO> getByRestaurantCategory(String res_id, String cat_id){
        try{
            RestaurantModel restaurant = restaurantRepo.findById(UUID.fromString(res_id)).orElseThrow(() -> new RuntimeException("Not found"));
            CategoryModel category = categoryRepository.findById(UUID.fromString(cat_id)).orElseThrow(() -> new RuntimeException("Not found"));
            ArrayList<MenuModel> menus = repo.getByRestaurantAndCategory(restaurant, category);
            ArrayList<MenuResponseDTO> restaurantMenus = new ArrayList<>();
            menus.forEach((menu) -> {
                MenuResponseDTO restaurantMenu = new MenuResponseDTO(menu.getId().toString(), menu.getRestaurant().getId().toString(), menu.getCategory().getId().toString(), menu.getName(), menu.getDescription(), menu.getImage_url(), menu.getPrice(), menu.getIs_available(), menu.getCreated_at(), menu.getUpdated_at());
                restaurantMenus.add(restaurantMenu);
            });
            return restaurantMenus;
        }
        catch (Exception ex){
            return null;
        }
    }

    @Override
    public MenuResponseDTO addMenu(MenuCreateDTO menuDetails){
        MenuModel menu = new MenuModel();
        menu.setName(menuDetails.getName());
        menu.setDescription(menuDetails.getDescription());
        menu.setImage_url(menuDetails.getImage_url());
        menu.setPrice(menuDetails.getPrice());
        menu.setIs_available(menuDetails.getIs_available());
        menu.setCreated_at(menuDetails.getCreated_at());
        menu.setUpdated_at(menuDetails.getUpdated_at());
        RestaurantModel restaurant = restaurantRepo.findById(UUID.fromString(menuDetails.getRestaurant())).orElseThrow(() -> new RuntimeException("Restaurant not found"));
        CategoryModel category = categoryRepository.findById(UUID.fromString(menuDetails.getCategory())).orElseThrow(() -> new RuntimeException("Category not found"));
        menu.setCategory(category);
        menu.setRestaurant(restaurant);
        MenuModel createdMenu = repo.save(menu);
        return new MenuResponseDTO(createdMenu.getId().toString(), createdMenu.getRestaurant().getId().toString(), createdMenu.getCategory().getId().toString(), createdMenu.getName(), createdMenu.getDescription(), createdMenu.getImage_url(), createdMenu.getPrice(), createdMenu.getIs_available(), createdMenu.getCreated_at(), createdMenu.getUpdated_at());
    }

}
