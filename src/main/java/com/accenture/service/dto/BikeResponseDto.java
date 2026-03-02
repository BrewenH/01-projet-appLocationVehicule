package com.accenture.service.dto;

public record BikeResponseDto(
        int id,
        int frameSize,
        int weight,
        String electric,
        String disckBrakes
        ) {
}
