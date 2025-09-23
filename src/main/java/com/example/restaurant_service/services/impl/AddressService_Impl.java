package com.example.restaurant_service.services.impl;

import com.example.restaurant_service.dto.requestDTOs.BranchCreateDTO;
import com.example.restaurant_service.dto.responseDTOs.BranchesResponseDTO;
import com.example.restaurant_service.dto.responseDTOs.RestaurantResponseDTO;
import com.example.restaurant_service.models.AddressModel;
import com.example.restaurant_service.models.RestaurantModel;
import com.example.restaurant_service.repositories.AddressRepository;
import com.example.restaurant_service.repositories.RestaurantRepo;
import com.example.restaurant_service.services.AddressService;
import com.example.restaurant_service.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class AddressService_Impl implements AddressService {

    @Autowired
    private AddressRepository repo;

    @Autowired
    private RestaurantRepo restaurantRepo;

    @Override
    public ArrayList<BranchesResponseDTO> getAddressByRestaurant(String id){
        try {
            ArrayList<AddressModel> addresses = repo.getByRestaurantId(UUID.fromString(id));
            ArrayList<BranchesResponseDTO> allBranches = new ArrayList<>();
            addresses.forEach((address) -> {
                BranchesResponseDTO branch = new BranchesResponseDTO(address.getId().toString(), address.getStreet_address(), address.getCity(), address.getState(), address.getPostal_code(), address.getLatitude(), address.getLongitude(), address.getIsDefault(), address.getUpdated_at());
                allBranches.add(branch);
            });
            return allBranches;
        }
        catch (Exception ex){
            return null;
        }
    }

    @Override
    public BranchesResponseDTO addBranch(BranchCreateDTO branch){
        RestaurantModel restaurant = restaurantRepo.getReferenceById(UUID.fromString(branch.getRestaurantId()));
        AddressModel address = new AddressModel();
        address.setStreet_address(branch.getStreet_address());
        address.setCity(branch.getCity());
        address.setState(branch.getState());
        address.setPostal_code(branch.getPostal_code());
        address.setLatitude(branch.getLatitude());
        address.setLongitude(branch.getLongitude());
        ArrayList<BranchesResponseDTO> addresses = getAddressByRestaurant(branch.getRestaurantId());
        if(!addresses.isEmpty()){
            address.setIsDefault(0);
        }
        else{
            address.setIsDefault(1);
        }
        address.setCreated_at(branch.getEstablishedAt());
        address.setUpdated_at(branch.getEstablishedAt());
        address.setRestaurant(restaurant);
        AddressModel newBranch = repo.save(address);
        return new BranchesResponseDTO(newBranch.getId().toString(), newBranch.getStreet_address(), newBranch.getCity(), newBranch.getState(), newBranch.getPostal_code(), newBranch.getLatitude(), newBranch.getLongitude(), newBranch.getIsDefault(), newBranch.getCreated_at());
    }
}
