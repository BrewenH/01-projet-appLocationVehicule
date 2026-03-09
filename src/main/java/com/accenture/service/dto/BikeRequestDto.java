package com.accenture.service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BikeRequestDto(
        @NotBlank(message = "bike.brand.null")
        String brand,
        @NotBlank(message = "bike.model.null")
        String model,
        @NotBlank(message = "bike.type.null")
        String type,
        @NotBlank(message = "bike.color.null")
        String color,
        @NotBlank(message = "bike.license.null")
        String license,
        @NotNull(message = "bike.mileage.null")
        int mileage,
        int dailyBaseRate,
        boolean active,
        boolean removedFromPark,

        int frameSize,
        int weight,
        boolean electric,
        boolean discBrakes,
        int batteryCapacity,
        int autonomy

) {

}
