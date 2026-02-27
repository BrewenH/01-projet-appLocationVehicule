package com.accenture.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Data
@Table(name = "CAMPER VAN")
public class CamperVan extends Vehicle{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int NumberOfSeats;
    private String energySources;
    private String transmission;
    private boolean airConditioning;
    private int weight;
    private int height;
    private int numberOfBeds;
    private String kitchenEquipment;
    private String bedLinens;
    private String refrigeratorEquipment;
    private String showerEquipment;

    public CamperVan(String brand, String model, String type, String color, String license, int mileage,
                     int dailyBaseRate, boolean active, boolean removedFromPark, int numberOfSeats, String energySources, String transmission, Boolean airConditioning, int weight, int height, String kitchenEquipment, int numberOfBeds, String bedLinens, String refrigeratorEquipment, String showerEquipment) {
        super(brand, model, type, color, license, mileage, dailyBaseRate, active, removedFromPark);
        NumberOfSeats = numberOfSeats;
        this.energySources = energySources;
        this.transmission = transmission;
        this.airConditioning = airConditioning;
        this.weight = weight;
        this.height = height;
        this.kitchenEquipment = kitchenEquipment;
        this.numberOfBeds = numberOfBeds;
        this.bedLinens = bedLinens;
        this.refrigeratorEquipment = refrigeratorEquipment;
        this.showerEquipment = showerEquipment;
    }
}
