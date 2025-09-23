package com.example.restaurant_service.dto.responseDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@AllArgsConstructor
@Getter
@Setter
public class RestaurantResponseDTO {
    private String id, name, description, phone_number, email, logo_url, status, owner_id;
    private int isActive;
    private Timestamp created_at, updated_at;
}
