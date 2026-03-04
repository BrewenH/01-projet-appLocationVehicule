package com.accenture.service;

import com.accenture.exception.UtilityVehicleException;
import com.accenture.service.dto.UtilityVehicleRequestDto;
import com.accenture.service.dto.UtilityVehicleResponseDto;

import java.util.List;

public interface UtilityVehicleService {
    void addUtilityVehicle(UtilityVehicleRequestDto dto) throws UtilityVehicleException;
    List<UtilityVehicleResponseDto> findAll();
    UtilityVehicleResponseDto findById(int id);
    void deleteUtilityVehicle(int id);
    UtilityVehicleResponseDto modifyUtilityVehicle(int id, UtilityVehicleRequestDto dto);
    UtilityVehicleResponseDto partiallyModifyingUtilityVehicle(int id, UtilityVehicleRequestDto dto);
}
