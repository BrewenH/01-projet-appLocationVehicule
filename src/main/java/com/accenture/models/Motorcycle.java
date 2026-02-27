//package com.accenture.models;
//
//import jakarta.persistence.*;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.ToString;
//
//@Entity
//@ToString(callSuper = true)
//@NoArgsConstructor
//@Data
//@Table(name = "MOTORCYCLE")
//public class Motorcycle extends Vehicle {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    private int numberOfCylinder;
//    private int engineDisplacement;
//    private int weight;
//    private int kWPower;
//    private int seatHeight;
//    private String transmission;
//
//    public Motorcycle(String brand, String model, String type, String color, String license, int mileage, int dailyBaseRate, boolean active, boolean removedFromPark, int numberOfCylinder, int engineDisplacement, int weight, int kWPower, int seatHeight,
//                      String transmission) {
//        super(brand, model, type, color, license, mileage, dailyBaseRate, active, removedFromPark);
//        this.numberOfCylinder = numberOfCylinder;
//        this.engineDisplacement = engineDisplacement;
//        this.weight = weight;
//        this.kWPower = kWPower;
//        this.seatHeight = seatHeight;
//        this.transmission = transmission;
//    }
//}
