package com.accenture.controller;

import com.accenture.service.dto.VehicleResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Tag(name = "Vehicle", description = "Vehicle management API")
@RequestMapping("/vehicles")
public interface VehicleApi {

    @Operation(summary = "List of all vehicles")
    @ApiResponse(responseCode = "2003", description = "List of vehicles")
    @GetMapping
    ResponseEntity<List<VehicleResponseDto>> getAll();
}
