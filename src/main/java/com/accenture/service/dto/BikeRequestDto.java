package com.accenture.service.dto;

import jakarta.validation.constraints.NotNull;

public record BikeRequestDto(
        String brand,
        String model,
        String type,
        String color,
        String license,
        int mileage,
        int dailyBaseRate,
        String active,
        String removedFromPark,

        int frameSize,
        int weight,
        String electric,
        String discBrakes

) {

}
