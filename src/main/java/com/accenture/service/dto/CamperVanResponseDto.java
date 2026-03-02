package com.accenture.service.dto;

public record CamperVanResponseDto(
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
