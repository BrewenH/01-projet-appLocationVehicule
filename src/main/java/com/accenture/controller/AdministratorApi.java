package com.accenture.controller;

import com.accenture.controller.advice.ErrorDto;
import com.accenture.service.dto.AdministratorRequestDto;
import com.accenture.service.dto.AdministratorResponseDto;
import com.accenture.service.dto.ClientRequestDto;
import com.accenture.service.dto.ClientResponseDto;
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

@Tag(name = "Administrator", description = "Administrator management API")
@RequestMapping("/administrators")
public interface AdministratorApi {

    @Operation(summary = "List of all administrators")
    @ApiResponse(responseCode = "200", description = "List of administrators")
    @GetMapping
    ResponseEntity<List<AdministratorResponseDto>> getAll();

    @Operation(summary = "Get administrator from his id")
    @ApiResponse(responseCode = "200", description = "Administrator found")
    @ApiResponse(responseCode = "404", description = "Administrator not found",
            content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    @GetMapping("/{id}")
    ResponseEntity<AdministratorResponseDto> getById(@Parameter(description = "Administrator ID", required = true) @PathVariable("id") UUID id);

    @Operation(summary = "Add new administrator")
    @ApiResponse(responseCode = "201", description = "Administrator created")
    @ApiResponse(responseCode = "404", description = "Administrator not found",
            content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    @PostMapping
    ResponseEntity<Void> add(@RequestBody AdministratorRequestDto requestDto);

    @Operation(summary = "Delete administrator from his id")
    @ApiResponse(responseCode = "200", description = "Administrator deleted")
    @ApiResponse(responseCode = "404", description = "Administrator not found",
            content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@Parameter(description = "Administrator ID", required = true) @PathVariable("id") UUID id);

    @Operation(summary = "Completely replace an Administrator ")
    @ApiResponse(responseCode = "200", description = "Administrator replaced")
    @ApiResponse(responseCode = "404", description = "Administrator not found",
            content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    @PutMapping("/{id}")
    ResponseEntity<AdministratorResponseDto> put(@Parameter(description = "ID of administrator", required = true)@PathVariable UUID id, @RequestBody AdministratorRequestDto requestDto);
}
