package com.accenture.repository;

import com.accenture.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    Optional<Client> findById(UUID id);

    void deleteById(UUID id);

    boolean existsById(UUID id);
}
