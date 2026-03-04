package com.accenture.service.dto;

public record UtilityVehicleResponseDto(
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
        String transmission,
        boolean airConditioning,
        int maximumWeight,
        int weight,
        int capacity
) {
}
