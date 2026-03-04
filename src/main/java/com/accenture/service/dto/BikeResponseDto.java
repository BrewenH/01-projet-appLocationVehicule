package com.accenture.service.dto;

import java.util.UUID;

public record BikeResponseDto(
        UUID id,

        String brand,
        String model,
        String type,
        String color,
        String license,
        int mileage,
        int dailyBaseRate,
        boolean active,
        boolean removedFromPark,

        int frameSize,
        int weight,
        boolean electric,
        boolean disckBrakes,
        int batteryCapacity,
        int autonomy
        ) {
}
