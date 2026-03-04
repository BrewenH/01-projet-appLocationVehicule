package com.accenture.service.dto;

import com.accenture.models.*;

import java.util.UUID;

public record VehicleResponseDto(
        UUID id,

        Bike bike,
        CamperVan camperVan,
        Car car,
        Motorbike motorbike,
        UtilityVehicle utilityVehicle
) {
}
