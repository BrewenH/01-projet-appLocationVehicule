package com.accenture.service.dto;

import java.util.UUID;

public record UtilityVehicleResponseDto(
        UUID id,

        String brand,
        String model,
        String color,
        String type,
        String license,
        int dailyBaseRate,
        int mileage,
        boolean active,
        boolean removedFromPark,

        int numberOfSeats,
        String energySources,
        String transmission,
        boolean airConditioning,
        int maximumWeight,
        int weight,
        int capacity
) {
}
