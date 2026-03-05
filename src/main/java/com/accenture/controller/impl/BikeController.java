package com.accenture.controller.impl;

import com.accenture.controller.BikeApi;
import com.accenture.service.BikeService;
import com.accenture.service.dto.BikeRequestDto;
import com.accenture.service.dto.BikeResponseDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;


@AllArgsConstructor
@RestController
public class BikeController implements BikeApi {

    private final BikeService bikeService;

    @Override
    public ResponseEntity<List<BikeResponseDto>> getAll() {
        return ResponseEntity.ok(bikeService.findAll());
    }

    @Override
    public ResponseEntity<BikeResponseDto> getById(UUID id) {
        return ResponseEntity.ok(bikeService.findById(id));
    }


    @Secured("ROLE_ADMIN")
    @Override
    public ResponseEntity<Void> add(BikeRequestDto requestDto) {
        bikeService.addBike(requestDto);
        List<BikeResponseDto> all = bikeService.findAll();
        UUID id = all.get(all.size() - 1).id();
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @Secured("ROLE_ADMIN")
    @Override
    public ResponseEntity<Void> delete(UUID id) {
        bikeService.deleteBike(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Secured("ROLE_ADMIN")
    @Override
    public ResponseEntity<BikeResponseDto> put(UUID id, @Valid BikeRequestDto requestDto) {
        BikeResponseDto responseDto = bikeService.modifyBike(id, requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @Secured("ROLE_ADMIN")
    @Override
    public ResponseEntity<BikeResponseDto> patch(UUID id, BikeRequestDto requestDto) {
        BikeResponseDto responseDto = bikeService.partiallyModifyingBike(id, requestDto);
        return ResponseEntity.ok(responseDto);
    }
}
