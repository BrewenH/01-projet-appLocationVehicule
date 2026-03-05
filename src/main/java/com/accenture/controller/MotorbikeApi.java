package com.accenture.controller;

import com.accenture.controller.advice.ErrorDto;
import com.accenture.service.dto.MotorbikeRequestDto;
import com.accenture.service.dto.MotorbikeResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Motorbike", description = "Motorbike management API")
@RequestMapping("/motobikes")
public interface MotorbikeApi {

    @Operation(summary = "List of all motorbikes")
    @ApiResponse(responseCode = "200", description = "List of motorbikes")
    @GetMapping
    ResponseEntity<List<MotorbikeResponseDto>> getAll();

    @Operation(summary = "Get motorbike from his id")
    @ApiResponse(responseCode = "200", description = "Motorbike found")
    @ApiResponse(responseCode = "404", description = "Motorbike not found",
            content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    @GetMapping("/{id}")
    ResponseEntity<MotorbikeResponseDto> getById(@Parameter(description = "Motorbike ID", required = true) @PathVariable("id") UUID id);

    @Operation(summary = "Add new motorbike")
    @ApiResponse(responseCode = "201", description = "Motorbike created")
    @ApiResponse(responseCode = "404", description = "Motorbike not found",
            content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    @PostMapping
    ResponseEntity<Void> add(@RequestBody MotorbikeRequestDto requestDto);

    @Operation(summary = "Delete motorbike from his id")
    @ApiResponse(responseCode = "200", description = "Motorbike deleted")
    @ApiResponse(responseCode = "404", description = "Motorbike not found",
            content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@Parameter(description = "Motorbike ID", required = true) @PathVariable("id") UUID id);

    @Operation(summary = "Completely replace a motorbike ")
    @ApiResponse(responseCode = "200", description = "Motorbike replaced")
    @ApiResponse(responseCode = "404", description = "Motorbike not found",
            content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    @PutMapping("/{id}")
    ResponseEntity<MotorbikeResponseDto> put(@Parameter(description = "ID of motorbike", required = true)@PathVariable UUID id, @RequestBody MotorbikeRequestDto requestDto);

    @Operation(summary = "Partially modify a motorbike")
    @ApiResponse(responseCode = "200", description = "Motorbike partially modify")
    @ApiResponse(responseCode = "404", description = "Motorbike not found",
            content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    @PatchMapping("/{id}")
    ResponseEntity<MotorbikeResponseDto> patch(@Parameter(description = "ID of motorbike", required = true)@PathVariable UUID id,@RequestBody MotorbikeRequestDto requestDto);
}
