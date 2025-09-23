package com.example.restaurant_service.repositories;

import com.example.restaurant_service.models.AddressModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.UUID;

public interface AddressRepository extends JpaRepository<AddressModel, UUID> {
    ArrayList<AddressModel> getByRestaurantId(UUID id);
}
