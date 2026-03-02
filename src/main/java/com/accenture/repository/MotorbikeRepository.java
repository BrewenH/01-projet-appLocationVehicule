package com.accenture.repository;

import com.accenture.models.Motorbike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotorbikeRepository extends JpaRepository<Motorbike, Integer> {
}
