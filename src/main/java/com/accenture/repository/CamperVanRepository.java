package com.accenture.repository;

import com.accenture.models.CamperVan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CamperVanRepository extends JpaRepository<CamperVan, UUID> {
}
