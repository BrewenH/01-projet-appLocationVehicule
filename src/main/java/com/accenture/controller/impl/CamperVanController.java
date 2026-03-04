package com.accenture.controller.impl;

import com.accenture.controller.CamperVanApi;
import com.accenture.service.CamperVanService;
import com.accenture.service.dto.CamperVanRequestDto;
import com.accenture.service.dto.CamperVanResponseDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
public class CamperVanController implements CamperVanApi {

    private final CamperVanService camperVanService;

    @Override
    public ResponseEntity<List<CamperVanResponseDto>> getAll() {
        return ResponseEntity.ok(camperVanService.findAll());
    }

    @Override
    public ResponseEntity<CamperVanResponseDto> getById(int id) {
        return ResponseEntity.ok(camperVanService.findById(id));
    }

    @Override
    public ResponseEntity<Void> add(CamperVanRequestDto requestDto) {
        camperVanService.addCamperVan(requestDto);
        List<CamperVanResponseDto> all = camperVanService.findAll();
        int id = all.get(all.size() - 1).id();
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @Override
    public ResponseEntity<Void> delete(int id) {
        camperVanService.deleteCamperVan(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public ResponseEntity<CamperVanResponseDto> put(int id, @Valid CamperVanRequestDto requestDto) {
        CamperVanResponseDto responseDto = camperVanService.modifyCamperVan(id, requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @Override
    public ResponseEntity<CamperVanResponseDto> patch(int id, CamperVanRequestDto requestDto) {
        CamperVanResponseDto responseDto = camperVanService.partiallyModifyingCamperVan(id, requestDto);
        return ResponseEntity.ok(responseDto);
    }
}
