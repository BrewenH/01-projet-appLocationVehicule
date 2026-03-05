package com.accenture.controller;

import com.accenture.controller.advice.ErrorDto;
import com.accenture.service.dto.BikeRequestDto;
import com.accenture.service.dto.BikeResponseDto;
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

@Tag(name = "Bike", description = "Bike management API")
@RequestMapping("/bikes")
public interface BikeApi {

    @Operation(summary = "List of all bikes")
    @ApiResponse(responseCode = "200", description = "List of bikes")
    @GetMapping
    ResponseEntity<List<BikeResponseDto>> getAll();

    @Operation(summary = "Get bike from his id")
    @ApiResponse(responseCode = "200", description = "Bike found")
    @ApiResponse(responseCode = "404", description = "Bike not found",
            content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    @GetMapping("/{id}")
    ResponseEntity<BikeResponseDto> getById(@Parameter(description = "Bike ID", required = true) @PathVariable("id") UUID id);

    @Operation(summary = "Add new bike")
    @ApiResponse(responseCode = "201", description = "Bike created")
    @ApiResponse(responseCode = "400", description = "Unvalid request",
            content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    @PostMapping
    ResponseEntity<Void> add(@RequestBody BikeRequestDto requestDto);

    @Operation(summary = "Delete bike from his id")
    @ApiResponse(responseCode = "200", description = "Bike deleted")
    @ApiResponse(responseCode = "404", description = "Bike not found",
            content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@Parameter(description = "Bike ID", required = true) @PathVariable("id") UUID id);



    @Operation(summary = "Completely replace a bike ")
    @ApiResponse(responseCode = "200", description = "Bike replaced")
    @ApiResponse(responseCode = "40", description = "Bike not found",
            content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    @ApiResponse(responseCode = "400", description = "Unvalid request",
            content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    @PutMapping("/{id}")
    ResponseEntity<BikeResponseDto> put(@Parameter(description = "ID of bike", required = true) @PathVariable UUID id, @RequestBody BikeRequestDto requestDto);

    @Operation(summary = "Partially modify a bike")
    @ApiResponse(responseCode = "200", description = "Bike partially modify")
    @ApiResponse(responseCode = "404", description = "Bike not found",
            content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    @PatchMapping("/{id}")
    ResponseEntity<BikeResponseDto> patch(@Parameter(description = "ID of bike", required = true) @PathVariable UUID id, @RequestBody BikeRequestDto requestDto);
}
