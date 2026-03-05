package com.accenture.service.dto;

import com.accenture.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AdministratorRequestDto(

        @NotBlank String lastName,
        @NotBlank String firstName,
        @Email String email,
        @Size(min = 8, max = 16) String password,
        Role role,
        @NotBlank String fonction
) {
}
