package com.accenture.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity(name = "AdministratorEntity")
@NoArgsConstructor
@Data
@Table(name = "ADMINISTRATOR")
public class Administrator extends User{

    private UUID id;

    private String fonction;

    public Administrator(String lastName, String firstName, String email, String password, String fonction) {
        super(lastName, firstName, email, password);
        this.fonction = fonction;
    }
}
