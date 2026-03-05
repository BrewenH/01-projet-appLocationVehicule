package com.accenture.controller;

import com.accenture.controller.advice.ErrorDto;
import com.accenture.service.dto.CarRequestDto;
import com.accenture.service.dto.CarResponseDto;
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

@Tag(name = "Car", description = "Car management API")
@RequestMapping("/cars")
public interface CarApi {

    @Operation(summary = "List of all cars")
    @ApiResponse(responseCode = "200", description = "List of cars")
    @GetMapping
    ResponseEntity<List<CarResponseDto>> getAll();

    @Operation(summary = "Get car from his id")
    @ApiResponse(responseCode = "200", description = "Car found")
    @ApiResponse(responseCode = "404", description = "Car not found",
            content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    @GetMapping("/{id}")
    ResponseEntity<CarResponseDto> getById(@Parameter(description = "Car ID", required = true) @PathVariable("id") UUID id);

    @Operation(summary = "Add new car")
    @ApiResponse(responseCode = "201", description = "Car created")
    @ApiResponse(responseCode = "404", description = "Car not found",
            content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    @PostMapping
    ResponseEntity<Void> add(@RequestBody CarRequestDto requestDto);

    @Operation(summary = "Delete car from his id")
    @ApiResponse(responseCode = "200", description = "Car deleted")
    @ApiResponse(responseCode = "404", description = "Car not found",
            content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@Parameter(description = "Car ID", required = true) @PathVariable("id") UUID id);

    @Operation(summary = "Completely replace a car ")
    @ApiResponse(responseCode = "200", description = "Car replaced")
    @ApiResponse(responseCode = "404", description = "Car not found",
            content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    @PutMapping("/{id}")
    ResponseEntity<CarResponseDto> put(@Parameter(description = "ID of car", required = true)@PathVariable UUID id, @RequestBody CarRequestDto requestDto);

    @Operation(summary = "Partially modify a car")
    @ApiResponse(responseCode = "200", description = "Car partially modify")
    @ApiResponse(responseCode = "404", description = "Car not found",
            content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    @PatchMapping("/{id}")
    ResponseEntity<CarResponseDto> patch(@Parameter(description = "ID of car", required = true)@PathVariable UUID id,@RequestBody CarRequestDto requestDto);

}
