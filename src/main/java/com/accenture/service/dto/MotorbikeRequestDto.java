package com.accenture.service.dto;

public record MotorbikeRequestDto(
        String brand,
        String model,
        String type,
        String color,
        String license,
        int mileage,
        int dailyBaseRate,
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
