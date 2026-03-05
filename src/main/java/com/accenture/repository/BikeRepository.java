package com.accenture.repository;

import com.accenture.models.Bike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface BikeRepository extends JpaRepository<Bike, UUID> {

}
