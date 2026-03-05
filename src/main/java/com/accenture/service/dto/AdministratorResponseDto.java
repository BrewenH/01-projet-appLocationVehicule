package com.accenture.service.dto;

import com.accenture.Role;

import java.util.UUID;

public record AdministratorResponseDto(
        UUID id,

        String lastName,
        String firstName,
        String email,
        String password,
        Role role,
        String fonction
) {
}
