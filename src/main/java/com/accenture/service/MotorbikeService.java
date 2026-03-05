package com.accenture.service;

import com.accenture.exception.MotorbikeException;
import com.accenture.service.dto.MotorbikeRequestDto;
import com.accenture.service.dto.MotorbikeResponseDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

public interface MotorbikeService {
    void addMotorbike(MotorbikeRequestDto dto) throws MotorbikeException;
    List<MotorbikeResponseDto> findAll();
    MotorbikeResponseDto findById(UUID id);
    void deleteMotorbike(UUID id);
    MotorbikeResponseDto modifyMotorbike(UUID id, MotorbikeRequestDto dto);
    MotorbikeResponseDto partiallyModifyingMotorbike(UUID id, MotorbikeRequestDto dto);
}
