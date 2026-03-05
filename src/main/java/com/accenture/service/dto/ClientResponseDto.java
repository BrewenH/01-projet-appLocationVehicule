package com.accenture.service.dto;

import com.accenture.Role;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record ClientResponseDto(
        UUID id,

        String lastName,
        String firstName,
        String email,
        String password,
        Role role,

        LocalDate birthDate,
        LocalDate registrationDate,
        List<String> licenseList,
        boolean desactivated
) {
}
