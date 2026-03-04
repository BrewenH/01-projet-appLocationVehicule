package com.accenture.service.dto;

public record UtilityVehicleRequestDto(
        String brand,
        String model,
        String type,
        String color,
        String license,
        int mileage,
        int dailyBaseRate,
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
