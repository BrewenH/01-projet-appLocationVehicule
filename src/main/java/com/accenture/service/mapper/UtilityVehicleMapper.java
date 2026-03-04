package com.accenture.service.mapper;

import com.accenture.models.UtilityVehicle;
import com.accenture.service.dto.UtilityVehicleRequestDto;
import com.accenture.service.dto.UtilityVehicleResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UtilityVehicleMapper {
    UtilityVehicle toUtilityVehicle(UtilityVehicleRequestDto dto);

    UtilityVehicleResponseDto toUtilityVehicleResponseDto(UtilityVehicle utilityVehicle);
}
