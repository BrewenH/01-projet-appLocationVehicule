package com.accenture.models;

import com.accenture.Role;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity(name = "AdministratorEntity")
@NoArgsConstructor
@Data
@Table(name = "ADMINISTRATOR")
public class Administrator extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String fonction;

    public Administrator(String lastName, String firstName, String email, String password, Role role, String fonction) {
        super(lastName, firstName, email, password, role);
        this.fonction = fonction;
    }
}
