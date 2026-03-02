package com.accenture.service;

import com.accenture.exception.CamperVanException;
import com.accenture.service.dto.CamperVanRequestDto;
import com.accenture.service.dto.CamperVanResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class CamperVanServiceImpl implements CamperVanService{
    @Override
    public void addCamperVan(CamperVanRequestDto dto) throws CamperVanException {

    }

    @Override
    public List<CamperVanResponseDto> findAll() {
        return List.of();
    }

    @Override
    public CamperVanResponseDto findById(int id) {
        return null;
    }

    @Override
    public void deleteCamperVan(int id) {

    }
}
