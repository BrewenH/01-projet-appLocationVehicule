package com.accenture.service.dto;

public record BikeRequestDto(
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
        boolean discBrakes,
        int batteryCapacity,
        int autonomy

) {

}
