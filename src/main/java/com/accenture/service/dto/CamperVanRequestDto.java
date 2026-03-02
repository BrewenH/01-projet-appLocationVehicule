package com.accenture.service.dto;

public record CamperVanRequestDto(
        String brand,
        String model,
        String color,
        String type,
        String license,
        int dailyBaseRate,
        int mileage,
        String active,
        String removedFromPark,

        int NumberOfSeats,
        String energySources,
        String transmission,
        String airConditioning,
        int weight,
        int height,
        int numberOfBeds,
        String kitchenEquipment,
        String bedLinens,
        String refrigeratorEquipment,
        String showerEquipment
) {
}
