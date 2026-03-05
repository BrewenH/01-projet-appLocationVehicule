package com.accenture.controller.impl;

import com.accenture.controller.AdministratorApi;
import com.accenture.service.AdministratorService;
import com.accenture.service.dto.AdministratorRequestDto;
import com.accenture.service.dto.AdministratorResponseDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
public class AdministratorController implements AdministratorApi {

    AdministratorService administratorService;

    @Override
    public ResponseEntity<List<AdministratorResponseDto>> getAll() {
        return ResponseEntity.ok(administratorService.findAll());
    }

    @Override
    public ResponseEntity<AdministratorResponseDto> getById(UUID id) {
        return ResponseEntity.ok(administratorService.findById(id));
    }

    @Override
    public ResponseEntity<Void> add(@Valid AdministratorRequestDto requestDto) {
        administratorService.addAdministrator(requestDto);
        List<AdministratorResponseDto> all = administratorService.findAll();
        UUID id = all.get(all.size() - 1).id();
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @Override
    public ResponseEntity<Void> delete(UUID id) {
        administratorService.deleteAdministrator(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public ResponseEntity<AdministratorResponseDto> put(UUID id, AdministratorRequestDto requestDto) {
        AdministratorResponseDto responseDto = administratorService.modifyAdministrator(id, requestDto);
        return ResponseEntity.ok(responseDto);
    }
}
