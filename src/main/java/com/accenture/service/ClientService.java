package com.accenture.service;

import com.accenture.exception.ClientException;
import com.accenture.service.dto.ClientRequestDto;
import com.accenture.service.dto.ClientResponseDto;

import java.util.List;
import java.util.UUID;

public interface ClientService {
    void addClient(ClientRequestDto dto) throws ClientException;
    List<ClientResponseDto> findAll();
    ClientResponseDto findById(UUID id);
    void deleteClient(UUID id);
    ClientResponseDto modifyClient(UUID id, ClientRequestDto dto);
}
