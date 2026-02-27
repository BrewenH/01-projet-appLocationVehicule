package com.accenture.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@ToString
@NoArgsConstructor
@Data
@Table(name = "BIKE")
public class Bike extends Vehicle{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int frameSize;
    private int weight;
    private boolean electric;
    private boolean discBrakes;

    public Bike(String brand, String model, String type, String color, String license, int mileage, int dailyBaseRate, boolean active, boolean removedFromPark, int frameSize, int weight, boolean electric, boolean discBrakes) {
        super(brand, model, type, color, license, mileage, dailyBaseRate, active, removedFromPark);
        this.frameSize = frameSize;
        this.weight = weight;
        this.electric = electric;
        this.discBrakes = discBrakes;
    }
}
