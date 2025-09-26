package com.example.restaurant_service.dto.responseDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MenuResponseDTO {
    private String id, restaurant, category, name, description, image_url;
    private Double price;
    private int is_available;
    private Timestamp created_at, updated_at;
}
