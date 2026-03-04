package com.accenture.controller.impl;

import com.accenture.controller.MotorbikeApi;
import com.accenture.service.MotorbikeService;
import com.accenture.service.dto.MotorbikeRequestDto;
import com.accenture.service.dto.MotorbikeResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class MotorbikeController implements MotorbikeApi {

    private final MotorbikeService motorbikeService;

    @Override
    public ResponseEntity<List<MotorbikeResponseDto>> getAll() {
        return ResponseEntity.ok(motorbikeService.findAll());
    }

    @Override
    public ResponseEntity<MotorbikeResponseDto> getById(int id) {
        return ResponseEntity.ok(motorbikeService.findById(id));
    }

    @Secured("ROLE_ADMIN")
    @Override
    public ResponseEntity<Void> add(MotorbikeRequestDto requestDto) {
        motorbikeService.addMotorbike(requestDto);
        List<MotorbikeResponseDto> all = motorbikeService.findAll();
        UUID id = all.get(all.size() - 1).id();
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @Override
    public ResponseEntity<Void> delete(int id) {
        motorbikeService.deleteMotorbike(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public ResponseEntity<MotorbikeResponseDto> put(int id, MotorbikeRequestDto requestDto) {
        MotorbikeResponseDto responseDto = motorbikeService.modifyMotorbike(id, requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @Override
    public ResponseEntity<MotorbikeResponseDto> patch(int id, MotorbikeRequestDto requestDto) {
        MotorbikeResponseDto responseDto = motorbikeService.partiallyModifyingMotorbike(id, requestDto);
        return ResponseEntity.ok(responseDto);
    }
}
