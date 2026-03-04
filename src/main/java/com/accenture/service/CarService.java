package com.accenture.service;

import com.accenture.exception.CarException;
import com.accenture.service.dto.CarRequestDto;
import com.accenture.service.dto.CarResponseDto;

import java.util.List;

public interface CarService {
    void addCar(CarRequestDto dto) throws CarException;
    List<CarResponseDto> findAll();
    CarResponseDto findById(int id);
    void deleteCar(int id);
    CarResponseDto modifyCar(int id, CarRequestDto dto);
    CarResponseDto partiallyModifyingCar(int id, CarRequestDto dto);
}
