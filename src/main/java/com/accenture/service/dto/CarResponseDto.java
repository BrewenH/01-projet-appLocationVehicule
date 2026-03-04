package com.accenture.service.dto;

import java.util.UUID;

public record CarResponseDto (
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
        int numberOfDoors,
        String transmission,
        boolean airConditioning,
        int numberOfLuggages
) {
}
