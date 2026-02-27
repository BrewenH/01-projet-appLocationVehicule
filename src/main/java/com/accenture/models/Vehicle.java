package com.accenture.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "VehicleEntity")
@Data
@NoArgsConstructor
@Table(name = "VEHICLE")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    private String brand;
    private String model;
    private String color;
    private String type;
    private String license;

    private int dailyBaseRate;
    private int mileage;
    private String active;
    private String removedFromPark;

    protected Vehicle(String brand, String model, String type, String color, String license, int mileage, int dailyBaseRate, String active, String removedFromPark) {
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.color = color;
        this.license = license;
        this.mileage = mileage;
        this.dailyBaseRate = dailyBaseRate;
        this.active = active;
        this.removedFromPark = removedFromPark;
    }
}
