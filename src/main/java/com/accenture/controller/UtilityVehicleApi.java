package com.accenture.controller;

import com.accenture.controller.advice.ErrorDto;
import com.accenture.service.dto.UtilityVehicleRequestDto;
import com.accenture.service.dto.UtilityVehicleResponseDto;
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

@Tag(name = "Utility Vehicle", description = "Utility vehicle management API")
@RequestMapping("/utility vehicles")
public interface UtilityVehicleApi {

    @Operation(summary = "List of all utility vehicles")
    @ApiResponse(responseCode = "200", description = "List of utility vehicles")
    @GetMapping
    ResponseEntity<List<UtilityVehicleResponseDto>> getAll();

    @Operation(summary = "Get utility vehicle from his id")
    @ApiResponse(responseCode = "200", description = "Utility vehicle found")
    @ApiResponse(responseCode = "404", description = "Utility vehicle not found",
            content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    @GetMapping("/{id}")
    ResponseEntity<UtilityVehicleResponseDto> getById(@Parameter(description = "Utility vehicle ID", required = true) @PathVariable("id") UUID id);

    @Operation(summary = "Add new utility vehicle")
    @ApiResponse(responseCode = "201", description = "Utility vehicle created")
    @ApiResponse(responseCode = "404", description = "Utility vehicle not found",
            content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    @PostMapping
    ResponseEntity<Void> add(@RequestBody UtilityVehicleRequestDto requestDto);

    @Operation(summary = "Delete utility vehicle from his id")
    @ApiResponse(responseCode = "200", description = "Utility vehicle deleted")
    @ApiResponse(responseCode = "404", description = "Utility vehicle not found",
            content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@Parameter(description = "Utility vehicle ID", required = true) @PathVariable("id") UUID id);

    @Operation(summary = "Completely replace a utility vehicle ")
    @ApiResponse(responseCode = "200", description = "Utility vehicle replaced")
    @ApiResponse(responseCode = "404", description = "Utility vehicle not found",
            content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    @PutMapping("/{id}")
    ResponseEntity<UtilityVehicleResponseDto> put(@Parameter(description = "ID of utility vehicle", required = true)@PathVariable UUID id, @RequestBody UtilityVehicleRequestDto requestDto);

    @Operation(summary = "Partially modify an utility vehicle")
    @ApiResponse(responseCode = "200", description = "Utility vehicle partially modify")
    @ApiResponse(responseCode = "404", description = "Utility vehicle not found",
            content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    @PatchMapping("/{id}")
    ResponseEntity<UtilityVehicleResponseDto> patch(@Parameter(description = "ID of utility vehicle", required = true)@PathVariable UUID id,@RequestBody UtilityVehicleRequestDto requestDto);
}

