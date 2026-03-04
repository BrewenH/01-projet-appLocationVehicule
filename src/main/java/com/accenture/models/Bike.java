package com.accenture.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity(name = "BikeEntity")
@NoArgsConstructor
@Data
@Table(name = "BIKE")
public class Bike extends Vehicle{


    private UUID id;

    private int frameSize;
    private int weight;
    private boolean electric;
    private boolean discBrakes;

    private int batteryCapacity;
    private int autonomy;


    public Bike(String brand, String model, String type, String color, String license, int mileage, int dailyBaseRate, boolean active, boolean removedFromPark, int frameSize, int weight, boolean electric, boolean discBrakes) {
        super(brand, model, type, color, license, mileage, dailyBaseRate, active, removedFromPark);
        this.frameSize = frameSize;
        this.weight = weight;
        this.electric = electric;
        this.discBrakes = discBrakes;

    }

    public Bike(String brand, String model, String type, String color, String license, int mileage, int dailyBaseRate, boolean active, boolean removedFromPark, int frameSize, int weight, boolean electric, boolean discBrakes, int batteryCapacity, int autonomy) {
        super(brand, model, type, color, license, mileage, dailyBaseRate, active, removedFromPark);
        this.frameSize = frameSize;
        this.weight = weight;
        this.electric = electric;
        this.discBrakes = discBrakes;
        this.batteryCapacity = batteryCapacity;
        this.autonomy = autonomy;
    }
}
