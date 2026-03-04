package com.accenture.service.mapper;

import com.accenture.models.Vehicle;
import com.accenture.service.dto.VehicleResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VehicleMapper {

    VehicleResponseDto toVehicleResponseDto(Vehicle vehicle);
}
