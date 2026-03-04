package com.accenture.service.mapper;

import com.accenture.models.Motorbike;
import com.accenture.service.dto.MotorbikeRequestDto;
import com.accenture.service.dto.MotorbikeResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MotorbikeMapper {
    Motorbike toMotorbike(MotorbikeRequestDto dto);

    MotorbikeResponseDto toMotorbikeResponseDto(Motorbike motorbike);
}
