package com.accenture.repository;

import com.accenture.models.Motorbike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface MotorbikeRepository extends JpaRepository<Motorbike, UUID> {

}
