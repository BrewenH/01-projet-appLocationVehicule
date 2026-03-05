package com.accenture.service;

import com.accenture.exception.UtilityVehicleException;
import com.accenture.service.dto.UtilityVehicleRequestDto;
import com.accenture.service.dto.UtilityVehicleResponseDto;

import java.util.List;
import java.util.UUID;

public interface UtilityVehicleService {
    void addUtilityVehicle(UtilityVehicleRequestDto dto) throws UtilityVehicleException;
    List<UtilityVehicleResponseDto> findAll();
    UtilityVehicleResponseDto findById(UUID id);
    void deleteUtilityVehicle(UUID id);
    UtilityVehicleResponseDto modifyUtilityVehicle(UUID id, UtilityVehicleRequestDto dto);
    UtilityVehicleResponseDto partiallyModifyingUtilityVehicle(UUID id, UtilityVehicleRequestDto dto);
}
