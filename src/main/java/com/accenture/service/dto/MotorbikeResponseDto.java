package com.accenture.service.dto;

public record MotorbikeResponseDto(
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

        int numberOfCylinder,
        int engineDisplacement,
        int weight,
        int kWPower,
        int seatHeight,
        String transmission
) {
}
