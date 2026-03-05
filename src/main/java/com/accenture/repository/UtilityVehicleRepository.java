package com.accenture.repository;

import com.accenture.models.UtilityVehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UtilityVehicleRepository extends JpaRepository<UtilityVehicle, UUID> {
}
