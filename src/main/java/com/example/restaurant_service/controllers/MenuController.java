package com.example.restaurant_service.controllers;

import com.example.restaurant_service.dto.requestDTOs.MenuCreateDTO;
import com.example.restaurant_service.dto.responseDTOs.MenuResponseDTO;
import com.example.restaurant_service.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    MenuService service;

    @GetMapping
    ResponseEntity<?> getMenu(@RequestParam(required = false) String cat_id, @RequestParam String res_id){
        if(cat_id != null){
            ArrayList<MenuResponseDTO> menus = service.getByRestaurantCategory(res_id, cat_id);
            return ResponseEntity.ok(menus);
        }
        ArrayList<MenuResponseDTO> menus = service.getByRestaurant(res_id);
        return ResponseEntity.ok(menus);
    }

    @PostMapping
    ResponseEntity<?> addMenu(@RequestBody MenuCreateDTO request){
        MenuResponseDTO menu = service.addMenu(request);
        return ResponseEntity.ok(menu);
    }
}
