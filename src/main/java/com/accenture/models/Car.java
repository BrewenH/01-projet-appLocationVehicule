package com.accenture.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "CarEntity")
@NoArgsConstructor
@Data
@Table(name = "CAR")
public class Car extends Vehicle {

    private int id;

    private int numberOfSeats;
    private String energySources;
    private int numberOfDoors;
    private String transmission;
    private String airConditioning;
    private int numberOfLuggages;

    public Car(String brand, String model, String type, String color, String license, int mileage, int dailyBaseRate, String active, String removedFromPark, int numberOfSeats, String energySources, int numberOfDoors, String transmission,
               String airConditioning, int numberOfLuggages) {
        super(brand, model, type, color, license, mileage, dailyBaseRate, active, removedFromPark);
        this.numberOfSeats = numberOfSeats;
        this.energySources = energySources;
        this.numberOfDoors = numberOfDoors;
        this.transmission = transmission;
        this.airConditioning = airConditioning;
        this.numberOfLuggages = numberOfLuggages;
    }
}
