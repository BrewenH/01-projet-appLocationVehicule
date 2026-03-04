package com.accenture.controller.impl;

import com.accenture.controller.VehicleApi;
import com.accenture.service.VehicleService;
import com.accenture.service.dto.VehicleResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class VehicleController implements VehicleApi {

    private final VehicleService vehicleService;

    @Override
    public ResponseEntity<List<VehicleResponseDto>> getAll() {
        return ResponseEntity.ok(vehicleService.findAll());
    }
}
