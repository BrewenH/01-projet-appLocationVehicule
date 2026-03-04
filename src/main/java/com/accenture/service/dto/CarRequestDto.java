package com.accenture.service.dto;

public record CarRequestDto(
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
        int numberOfDoors,
        String transmission,
        boolean airConditioning,
        int numberOfLuggages
) {


}
