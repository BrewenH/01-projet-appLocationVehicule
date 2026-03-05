package com.accenture.controller.impl;

import com.accenture.controller.UtilityVehicleApi;
import com.accenture.service.UtilityVehicleService;
import com.accenture.service.dto.UtilityVehicleRequestDto;
import com.accenture.service.dto.UtilityVehicleResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class UtilityVehicleController implements UtilityVehicleApi {

    private final UtilityVehicleService utilityVehicleService;

    @Override
    public ResponseEntity<List<UtilityVehicleResponseDto>> getAll() {
        return ResponseEntity.ok(utilityVehicleService.findAll());
    }

    @Override
    public ResponseEntity<UtilityVehicleResponseDto> getById(UUID id) {
        return ResponseEntity.ok(utilityVehicleService.findById(id));
    }

    @Override
    public ResponseEntity<Void> add(UtilityVehicleRequestDto requestDto) {
        utilityVehicleService.addUtilityVehicle(requestDto);
        List<UtilityVehicleResponseDto> all = utilityVehicleService.findAll();
        UUID id = all.get(all.size() -1).id();
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @Override
    public ResponseEntity<Void> delete(UUID id) {
        utilityVehicleService.deleteUtilityVehicle(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public ResponseEntity<UtilityVehicleResponseDto> put(UUID id, UtilityVehicleRequestDto requestDto) {
        UtilityVehicleResponseDto responseDto = utilityVehicleService.modifyUtilityVehicle(id, requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @Override
    public ResponseEntity<UtilityVehicleResponseDto> patch(UUID id, UtilityVehicleRequestDto requestDto) {
        UtilityVehicleResponseDto responseDto = utilityVehicleService.partiallyModifyingUtilityVehicle(id, requestDto);
        return ResponseEntity.ok(responseDto);
    }
}
