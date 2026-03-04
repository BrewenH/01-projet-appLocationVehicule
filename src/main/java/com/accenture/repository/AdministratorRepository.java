package com.accenture.repository;

import com.accenture.models.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AdministratorRepository extends JpaRepository<Administrator, Integer> {
    Optional<Administrator> findById(UUID id);

    boolean existsById(UUID id);

    void deleteById(UUID id);
}
