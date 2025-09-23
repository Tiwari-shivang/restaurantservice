package com.example.restaurant_service.dto.requestDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class RestaurantCreateDTO {
    private String name, description, phone_number, email, logo_url, status, owner_id;
    private int isActive;
}
