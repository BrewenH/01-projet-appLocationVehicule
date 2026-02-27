//package com.accenture.models;
//
//import jakarta.persistence.*;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.ToString;
//
//@Entity
//@ToString
//@NoArgsConstructor
//@Data
//@Table(name = "UTILITY VEHICLE")
//public class UtilityVehicle extends Vehicle{
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    private int numberOfSeats;
//    private String energySources;
//    private String transmission;
//    private boolean airConditioning;
//    private int maximumWeight;
//    private int weight;
//    private int capacity;
//
//    public UtilityVehicle(String brand, String model, String type, String color, String license, int mileage, int dailyBaseRate, boolean active, boolean removedFromPark, int numberOfSeats, String energySources, String transmission, boolean airConditioning, int maximumWeight, int weight, int capacity) {
//        super(brand, model, type, color, license, mileage, dailyBaseRate, active, removedFromPark);
//        this.numberOfSeats = numberOfSeats;
//        this.energySources = energySources;
//        this.transmission = transmission;
//        this.airConditioning = airConditioning;
//        this.maximumWeight = maximumWeight;
//        this.weight = weight;
//        this.capacity = capacity;
//    }
//}
