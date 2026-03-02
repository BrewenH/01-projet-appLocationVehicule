package com.accenture.service;

import com.accenture.exception.BikeException;
import com.accenture.exception.CamperVanException;
import com.accenture.service.dto.BikeRequestDto;
import com.accenture.service.dto.BikeResponseDto;
import com.accenture.service.dto.CamperVanRequestDto;
import com.accenture.service.dto.CamperVanResponseDto;

import java.util.List;

public interface CamperVanService {
    void addCamperVan(CamperVanRequestDto dto) throws CamperVanException;
    List<CamperVanResponseDto> findAll();
    CamperVanResponseDto findById(int id);
    void deleteCamperVan(int id);

}
