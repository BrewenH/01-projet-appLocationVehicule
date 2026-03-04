package com.accenture.controller;

import com.accenture.controller.advice.ErrorDto;
import com.accenture.service.dto.CamperVanRequestDto;
import com.accenture.service.dto.CamperVanResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Campervan", description = "Campervan management API")
@RequestMapping("/campervan")
public interface CamperVanApi {

    @Operation(summary = "List of all campervans")
    @ApiResponse(responseCode = "200", description = "List of campervans")
    @GetMapping
    ResponseEntity<List<CamperVanResponseDto>> getAll();

    @Operation(summary = "Get campervan from his id")
    @ApiResponse(responseCode = "200", description = "Campervan found")
    @ApiResponse(responseCode = "404", description = "Campervan not found",
            content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    @GetMapping("/{id}")
    ResponseEntity<CamperVanResponseDto> getById(@Parameter(description = "Campervan ID", required = true) @PathVariable("id") int id);

    @Operation(summary = "Add new campervan")
    @ApiResponse(responseCode = "201", description = "Campervan created")
    @ApiResponse(responseCode = "404", description = "Campervan not found",
            content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    @PostMapping
    ResponseEntity<Void> add(@RequestBody CamperVanRequestDto requestDto);

    @Operation(summary = "Delete campervan from his id")
    @ApiResponse(responseCode = "200", description = "Campervan deleted")
    @ApiResponse(responseCode = "404", description = "Campervan not found",
            content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@Parameter(description = "Campervan ID", required = true) @PathVariable("id") int id);

    @Operation(summary = "Completely replace a campervan ")
    @ApiResponse(responseCode = "200", description = "Campervan replaced")
    @ApiResponse(responseCode = "404", description = "Campervan not found",
            content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    @PutMapping("/{id}")
    ResponseEntity<CamperVanResponseDto> put(@Parameter(description = "ID of campervan", required = true)@PathVariable int id, @RequestBody CamperVanRequestDto requestDto);

    @Operation(summary = "Partially modify a campervan")
    @ApiResponse(responseCode = "200", description = "Campervan partially modify")
    @ApiResponse(responseCode = "404", description = "Campervan not found",
            content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    @PatchMapping("/{id}")
    ResponseEntity<CamperVanResponseDto> patch(@Parameter(description = "ID of campervan", required = true)@PathVariable int id,@RequestBody CamperVanRequestDto requestDto);
}
