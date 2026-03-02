package com.accenture.repository;

import com.accenture.models.Bike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BikeRepository extends JpaRepository<Bike, Integer> {


}
