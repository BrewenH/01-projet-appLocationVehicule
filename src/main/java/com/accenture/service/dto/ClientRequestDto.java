package com.accenture.service.dto;

import jakarta.validation.constraints.NotBlank;

public record ClientRequestDto(

        @NotBlank(message = "Last name must not be blank") String lastName,
        @NotBlank(message = "Firstname must not be blank") String firstName


) {
}
