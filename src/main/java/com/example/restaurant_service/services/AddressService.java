package com.example.restaurant_service.services;

import com.example.restaurant_service.dto.requestDTOs.BranchCreateDTO;
import com.example.restaurant_service.dto.responseDTOs.BranchesResponseDTO;
import com.example.restaurant_service.models.AddressModel;

import java.util.ArrayList;

public interface AddressService {
    ArrayList<BranchesResponseDTO> getAddressByRestaurant(String restaurantId);
    BranchesResponseDTO addBranch(BranchCreateDTO branch);
}
