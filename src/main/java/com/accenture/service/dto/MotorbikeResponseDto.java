package com.accenture.service.dto;

import java.util.UUID;

public record MotorbikeResponseDto(
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

        int numberOfCylinder,
        int engineDisplacement,
        int weight,
        int kWPower,
        int seatHeight,
        String transmission
) {
}
