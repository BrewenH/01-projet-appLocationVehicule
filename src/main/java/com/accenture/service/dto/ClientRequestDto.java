package com.accenture.service.dto;

import com.accenture.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;

public record ClientRequestDto(
        @NotBlank(message = "lastname.null") String lastName,
        @NotBlank(message = "firstname.null") String firstName,
        @Email String email,
        @Size(min = 8, max = 16) String password,
        Role role,

        @Past LocalDate birthDate,
        LocalDate registrationDate,
        List<String> licenseList,
        boolean desactivated
) {
}
