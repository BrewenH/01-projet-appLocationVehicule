package com.accenture.controller;

import com.accenture.controller.advice.ErrorDto;
import com.accenture.service.dto.CarRequestDto;
import com.accenture.service.dto.CarResponseDto;
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

@Tag(name = "Client", description = "Client management API")
@RequestMapping("/clients")
public interface ClientApi {

    @Operation(summary = "List of all clients")
    @ApiResponse(responseCode = "200", description = "List of clients")
    @GetMapping
    ResponseEntity<List<ClientResponseDto>> getAll();

    @Operation(summary = "Get client from his id")
    @ApiResponse(responseCode = "200", description = "Car found")
    @ApiResponse(responseCode = "404", description = "Car not found",
            content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    @GetMapping("/{id}")
    ResponseEntity<ClientResponseDto> getById(@Parameter(description = "Client ID", required = true) @PathVariable("id") UUID id);

    @Operation(summary = "Add new client")
    @ApiResponse(responseCode = "200", description = "Client created")
    @ApiResponse(responseCode = "404", description = "Client not found",
            content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    @PostMapping
    ResponseEntity<Void> add(@RequestBody ClientRequestDto requestDto);

    @Operation(summary = "Delete client from his id")
    @ApiResponse(responseCode = "200", description = "Client deleted")
    @ApiResponse(responseCode = "404", description = "Client not found",
            content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@Parameter(description = "Client ID", required = true) @PathVariable("id") UUID id);

    @Operation(summary = "Completely replace a client ")
    @ApiResponse(responseCode = "200", description = "Client replaced")
    @ApiResponse(responseCode = "404", description = "Client not found",
            content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    @PutMapping("/{id}")
    ResponseEntity<ClientResponseDto> put(@Parameter(description = "ID of client", required = true)@PathVariable UUID id, @RequestBody ClientRequestDto requestDto);

}
