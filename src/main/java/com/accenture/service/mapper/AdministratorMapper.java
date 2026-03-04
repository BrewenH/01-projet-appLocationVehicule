package com.accenture.service.mapper;

import com.accenture.models.Administrator;
import com.accenture.service.dto.AdministratorRequestDto;
import com.accenture.service.dto.AdministratorResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdministratorMapper {

    Administrator toAdministrator(AdministratorRequestDto dto);

    AdministratorResponseDto toAdministratorResponseDto(Administrator administrator);
}
