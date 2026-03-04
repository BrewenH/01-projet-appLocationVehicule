package com.accenture.service;

import com.accenture.exception.MotorbikeException;
import com.accenture.service.dto.MotorbikeRequestDto;
import com.accenture.service.dto.MotorbikeResponseDto;

import java.util.List;

public interface MotorbikeService {
    void addMotorbike(MotorbikeRequestDto dto) throws MotorbikeException;
    List<MotorbikeResponseDto> findAll();
    MotorbikeResponseDto findById(int id);
    void deleteMotorbike(int id);
    MotorbikeResponseDto modifyMotorbike(int id, MotorbikeRequestDto dto);
    MotorbikeResponseDto partiallyModifyingMotorbike(int id, MotorbikeRequestDto dto);
}
