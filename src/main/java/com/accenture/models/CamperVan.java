package com.accenture.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "CampervanEntity")
@NoArgsConstructor
@Data
@Table(name = "CAMPERVAN")
public class CamperVan extends Vehicle{


    private int id;

    private int numberOfSeats;
    private String energySources;
    private String transmission;
    private boolean airConditioning;
    private int weight;
    private int height;
    private int numberOfBeds;
    private boolean kitchenEquipment;
    private boolean bedLinens;
    private boolean refrigeratorEquipment;
    private boolean showerEquipment;

    public CamperVan(String brand, String model, String type, String color, String license, int mileage, int dailyBaseRate, boolean active, boolean removedFromPark, int numberOfSeats, String energySources, String transmission, boolean airConditioning, int weight, int height, int numberOfBeds, boolean kitchenEquipment, boolean refrigeratorEquipment, boolean showerEquipment, boolean bedLinens) {
        super(brand, model, type, color, license, mileage, dailyBaseRate, active, removedFromPark);
        this.numberOfSeats = numberOfSeats;
        this.energySources = energySources;
        this.transmission = transmission;
        this.airConditioning = airConditioning;
        this.weight = weight;
        this.height = height;
        this.numberOfBeds = numberOfBeds;
        this.kitchenEquipment = kitchenEquipment;
        this.refrigeratorEquipment = refrigeratorEquipment;
        this.showerEquipment = showerEquipment;
        this.bedLinens = bedLinens;
    }
}
