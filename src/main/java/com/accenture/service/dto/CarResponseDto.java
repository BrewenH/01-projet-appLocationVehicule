package com.accenture.service.dto;

public record CarResponseDto (
        int id,

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
