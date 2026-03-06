package com.accenture.controller.impl;

import com.accenture.controller.CarApi;
import com.accenture.service.CarService;
import com.accenture.service.dto.CarRequestDto;
import com.accenture.service.dto.CarResponseDto;
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

@RestController
@AllArgsConstructor
public class CarController implements CarApi {

    private final CarService carService;

    @Override
    public ResponseEntity<List<CarResponseDto>> getAll() {
        return ResponseEntity.ok(carService.findAll());
    }

    @Override
    public ResponseEntity<CarResponseDto> getById(UUID id) {
        return ResponseEntity.ok(carService.findById(id));
    }

    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    @Override
    public ResponseEntity<Void> add(CarRequestDto requestDto) {
        carService.addCar(requestDto);
        List<CarResponseDto> all = carService.findAll();
        UUID id = all.get(all.size() - 1).id();
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    @Override
    public ResponseEntity<Void> delete(UUID id) {
        carService.deleteCar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    @Override
    public ResponseEntity<CarResponseDto> put(UUID id, CarRequestDto requestDto) {
        CarResponseDto responseDto = carService.modifyCar(id, requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    @Override
    public ResponseEntity<CarResponseDto> patch(UUID id, CarRequestDto requestDto) {
        CarResponseDto responseDto = carService.partiallyModifyingCar(id, requestDto);
        return ResponseEntity.ok(responseDto);
    }
}
