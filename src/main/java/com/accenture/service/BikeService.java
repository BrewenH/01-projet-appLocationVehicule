package com.accenture.service;

import com.accenture.exception.BikeException;
import com.accenture.service.dto.BikeRequestDto;
import com.accenture.service.dto.BikeResponseDto;

import java.util.List;
import java.util.UUID;

public interface BikeService {
    void addBike(BikeRequestDto dto) throws BikeException;
    List<BikeResponseDto> findAll();
    BikeResponseDto findById(UUID id);
    void deleteBike(UUID id);
    BikeResponseDto modifyBike(UUID id, BikeRequestDto dto);
    BikeResponseDto partiallyModifyingBike(UUID id, BikeRequestDto dto);
}
