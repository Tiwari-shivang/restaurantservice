package com.example.restaurant_service.dto.responseDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfileCompletion {
    private Double percComp;
    private Boolean isAddress;
    private Boolean isCategory;
    private Boolean isMenu;
}
