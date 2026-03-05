package com.accenture.models;

import com.accenture.Role;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity(name = "UserEntity")
@NoArgsConstructor
@Data
@Table(name = "USER")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String lastName;
    private String firstName;
    private String email;
    private String password;
    private Role role;

    public User(String lastName, String firstName, String email, String password, Role role) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
