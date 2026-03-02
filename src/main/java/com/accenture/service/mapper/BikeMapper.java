package com.accenture.service.mapper;

import com.accenture.models.Bike;
import com.accenture.service.dto.BikeRequestDto;
import com.accenture.service.dto.BikeResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BikeMapper {
    Bike toBike(BikeRequestDto dto);

    BikeResponseDto toBikeResponseDto(Bike bike);
}
