package com.accenture.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Entity(name = "CarEntity")
@NoArgsConstructor
@Data
@Table(name = "CAR")
public class Car extends Vehicle {

    private UUID id;

    private int numberOfSeats;
    private String energySources;
    private int numberOfDoors;
    private String transmission;
    private boolean airConditioning;
    private int numberOfLuggages;

    public Car(String brand, String model, String type, String color, String license, int mileage, int dailyBaseRate, boolean active, boolean removedFromPark, int numberOfSeats, String energySources, int numberOfDoors, String transmission, boolean airConditioning, int numberOfLuggages) {
        super(brand, model, type, color, license, mileage, dailyBaseRate, active, removedFromPark);
        this.numberOfSeats = numberOfSeats;
        this.energySources = energySources;
        this.numberOfDoors = numberOfDoors;
        this.transmission = transmission;
        this.airConditioning = airConditioning;
        this.numberOfLuggages = numberOfLuggages;
    }
}
