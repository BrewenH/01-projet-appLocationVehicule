package com.accenture.service;

import com.accenture.exception.BikeException;
import com.accenture.service.dto.BikeRequestDto;
import com.accenture.service.dto.BikeResponseDto;

import java.util.Collection;
import java.util.List;

public interface BikeService {
    void addBike(BikeRequestDto dto) throws BikeException;
    List<BikeResponseDto> findAll();
    BikeResponseDto findById(int id);
    void deleteBike(int id);
    BikeResponseDto modifyBike(int id, BikeRequestDto dto);
    BikeResponseDto partiallyModifyingBike(int id, BikeRequestDto dto);
}
