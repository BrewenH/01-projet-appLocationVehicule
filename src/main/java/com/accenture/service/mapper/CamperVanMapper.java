package com.accenture.service.mapper;


import com.accenture.models.CamperVan;
import com.accenture.service.dto.CamperVanRequestDto;
import com.accenture.service.dto.CamperVanResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CamperVanMapper {
    CamperVan toCamperVan(CamperVanRequestDto dto);

    CamperVanResponseDto toCamperVanResponseDto(CamperVan camperVan);
}
