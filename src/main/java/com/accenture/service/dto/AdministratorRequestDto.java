package com.accenture.service.dto;

public record AdministratorRequestDto(

        String lastName,
        String firstName,
        String email,
        String password,
        String fonction
) {
}
