package com.accenture.service;

import com.accenture.exception.CarException;
import com.accenture.service.dto.CarRequestDto;
import com.accenture.service.dto.CarResponseDto;

import java.util.List;
import java.util.UUID;

public interface CarService {
    void addCar(CarRequestDto dto) throws CarException;
    List<CarResponseDto> findAll();
    CarResponseDto findById(UUID id);
    void deleteCar(UUID id);
    CarResponseDto modifyCar(UUID id, CarRequestDto dto);
    CarResponseDto partiallyModifyingCar(UUID id, CarRequestDto dto);
}
