package com.example.restaurant_service.services;

import com.example.restaurant_service.dto.requestDTOs.RestaurantCreateDTO;
import com.example.restaurant_service.dto.requestDTOs.SearchFilterRequest;
import com.example.restaurant_service.dto.responseDTOs.ProfileCompletion;
import com.example.restaurant_service.dto.responseDTOs.RestaurantResponseDTO;

import java.util.ArrayList;

public interface RestaurantService {
    RestaurantResponseDTO addRestaurant(RestaurantCreateDTO restaurant);
    ProfileCompletion getCompletion(String id);
//    RestaurantResponseDTO updateRestaurant(String id, RestaurantCreateDTO restaurant);
    RestaurantResponseDTO getRestaurantDetails(String id);
//    ArrayList<RestaurantResponseDTO> getRestaurants(SearchFilterRequest filter);
}
