package com.example.restaurant_service.controllers;

import com.example.restaurant_service.dto.requestDTOs.RestaurantCreateDTO;
import com.example.restaurant_service.dto.responseDTOs.ProfileCompletion;
import com.example.restaurant_service.dto.responseDTOs.RestaurantResponseDTO;
import com.example.restaurant_service.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    private RestaurantService service;

    @PostMapping
    public ResponseEntity<?> addRestaurant(@RequestBody RestaurantCreateDTO req){
        RestaurantResponseDTO resp = service.addRestaurant(req);
        return ResponseEntity.ok(resp);
    }

    @GetMapping
    public ResponseEntity<?> getRestaurants(@RequestParam(required = false) String id){
        if(id != null){
            RestaurantResponseDTO response = service.getRestaurantDetails(id);
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.ok("Route working");
    }

    @PutMapping
    public ResponseEntity<?> updateRestaurant(){
        return ResponseEntity.ok("Route working");
    }

    @DeleteMapping
    public ResponseEntity<?> deleteRestaurant(){
        return ResponseEntity.ok("Route working");
    }

    @GetMapping("/completion/{id}")
    public ResponseEntity<?> getPercentageCompletion(@PathVariable("id") String id){
        ProfileCompletion resp = service.getCompletion(id);
        return ResponseEntity.ok(resp);
    }
}
