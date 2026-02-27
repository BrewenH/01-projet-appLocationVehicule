package com.accenture.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "VEHICLE")
public abstract class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String brand;
    private String model;
    private String color;
    private String type;
    private String license;

    private int dailyBaseRate;
    private int mileage;
    private boolean active;
    private boolean removedFromPark;

    protected Vehicle(String brand, String model, String type, String color, String license, int mileage, int dailyBaseRate, boolean active, boolean removedFromPark) {
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
