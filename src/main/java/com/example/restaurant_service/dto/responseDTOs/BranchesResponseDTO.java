package com.example.restaurant_service.dto.responseDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BranchesResponseDTO {
    private String id, street_address, city, state, postal_code;
    private Double latitude, longitude;
    private int isDefault;
    private Timestamp establishedAt;
}
