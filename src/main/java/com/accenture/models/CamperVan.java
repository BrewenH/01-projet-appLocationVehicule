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
    private String airConditioning;
    private int weight;
    private int height;
    private int numberOfBeds;
    private String kitchenEquipment;
    private String bedLinens;
    private String refrigeratorEquipment;
    private String showerEquipment;

    public CamperVan(String brand, String model, String type, String color, String license, int mileage, int dailyBaseRate, String active, String removedFromPark, int numberOfSeats, String energySources, String transmission,
                     String airConditioning, int weight, int numberOfBeds, int height, String kitchenEquipment, String bedLinens, String refrigeratorEquipment, String showerEquipment) {
        super(brand, model, type, color, license, mileage, dailyBaseRate, active, removedFromPark);
        NumberOfSeats = numberOfSeats;
        this.energySources = energySources;
        this.transmission = transmission;
        this.airConditioning = airConditioning;
        this.weight = weight;
        this.numberOfBeds = numberOfBeds;
        this.height = height;
        this.kitchenEquipment = kitchenEquipment;
        this.bedLinens = bedLinens;
        this.refrigeratorEquipment = refrigeratorEquipment;
        this.showerEquipment = showerEquipment;
    }
}
