package com.accenture.service;

import com.accenture.repository.VehicleRepository;
import com.accenture.service.dto.VehicleResponseDto;
import com.accenture.service.mapper.VehicleMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class VehicleServiceImpl implements VehicleService{
    
    private final VehicleRepository vehicleRepository;
    private final VehicleMapper vehicleMapper;
    
    @Override
    public List<VehicleResponseDto> findAll() {
        return vehicleRepository.findAll().stream()
                .map(vehicleMapper::toVehicleResponseDto)
                .toList();
    }

}
