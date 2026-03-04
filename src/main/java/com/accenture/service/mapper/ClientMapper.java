package com.accenture.service.mapper;

import com.accenture.models.Client;
import com.accenture.service.dto.ClientRequestDto;
import com.accenture.service.dto.ClientResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    Client toClient(ClientRequestDto dto);

    ClientResponseDto toClientResponseDto(Client client);
}
