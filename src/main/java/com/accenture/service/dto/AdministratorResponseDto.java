package com.accenture.service.dto;

import java.util.UUID;

public record AdministratorResponseDto(
        UUID id,

        String lastName,
        String firstName,
        String email,
        String password,
        String fonction
) {
}
