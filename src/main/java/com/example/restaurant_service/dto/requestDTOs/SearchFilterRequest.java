package com.example.restaurant_service.dto.requestDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchFilterRequest {
    private Integer distance;
    private Float ratings;
    private String cuisine, sorting, textSearch;
    private Double pricing;
    private Boolean availability;
}
