package com.example.restaurant_service.dto.requestDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BranchCreateDTO {
    private String restaurantId, street_address, city, state, postal_code;
    private Double latitude, longitude;
    private Timestamp establishedAt;
}
