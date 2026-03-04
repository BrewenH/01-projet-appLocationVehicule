package com.accenture.service.dto;

import com.accenture.models.*;

public record VehicleRequestDto(
        Bike bike,
        CamperVan camperVan,
        Car car,
        Motorbike motorbike,
        UtilityVehicle utilityVehicle
) {
}
