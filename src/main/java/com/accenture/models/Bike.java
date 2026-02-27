package com.accenture.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "BikeEntity")
@NoArgsConstructor
@Data
@Table(name = "BIKE")
public class Bike extends Vehicle{


    private int id;

    private int frameSize;
    private int weight;
    private String electric;
    private String discBrakes;

    public Bike(String brand, String model, String type, String color, String license, int mileage, int dailyBaseRate,
                String active, String removedFromPark, int frameSize, int weight, String electric, String discBrakes) {
        super(brand, model, type, color, license, mileage, dailyBaseRate, active, removedFromPark);
        this.frameSize = frameSize;
        this.weight = weight;
        this.electric = electric;
        this.discBrakes = discBrakes;
    }
}
