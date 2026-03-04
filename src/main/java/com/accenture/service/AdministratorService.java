package com.accenture.service;



import com.accenture.exception.AdministratorException;
import com.accenture.service.dto.AdministratorRequestDto;
import com.accenture.service.dto.AdministratorResponseDto;

import java.util.List;
import java.util.UUID;

public interface AdministratorService {
    void addAdministrator(AdministratorRequestDto dto) throws AdministratorException;
    List<AdministratorResponseDto> findAll();
    AdministratorResponseDto findById(UUID id);
    void deleteAdministrator(UUID id);
    AdministratorResponseDto modifyAdministrator(UUID id, AdministratorRequestDto dto);
}
