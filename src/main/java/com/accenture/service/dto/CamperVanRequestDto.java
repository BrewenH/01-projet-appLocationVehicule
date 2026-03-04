package com.accenture.service.dto;

public record CamperVanRequestDto(
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
        int weight,
        int height,
        int numberOfBeds,
        boolean kitchenEquipment,
        boolean bedLinens,
        boolean refrigeratorEquipment,
        boolean showerEquipment
) {
}
