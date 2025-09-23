package com.example.restaurant_service.controllers;

import com.example.restaurant_service.dto.requestDTOs.BranchCreateDTO;
import com.example.restaurant_service.dto.responseDTOs.BranchesResponseDTO;
import com.example.restaurant_service.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/branch")
public class AddressController {
    @Autowired
    private AddressService service;
    @GetMapping("/{id}")
    ResponseEntity<?> getAllBranches(@PathVariable("id") String id){
        ArrayList<BranchesResponseDTO> branches = service.getAddressByRestaurant(id);
        return ResponseEntity.ok(branches);
    }

    @PostMapping
    ResponseEntity<?> addBranch(@RequestBody BranchCreateDTO branch){
        BranchesResponseDTO newBranch = service.addBranch(branch);
        return ResponseEntity.ok(newBranch);
    }
}
