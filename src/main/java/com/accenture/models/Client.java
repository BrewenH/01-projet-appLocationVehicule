//package com.accenture.models;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.Table;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.time.LocalDate;
//import java.util.List;
//import java.util.UUID;
//
//@Entity(name = "ClientEntity")
//@NoArgsConstructor
//@Data
//@Table(name = "CLIENT")
//public class Client extends User {
//
//    private UUID id;
//
//    private LocalDate birthDate;
//    private LocalDate registrationDate;
//    private List<String> licenseList;
//    private boolean desactivated;
//
//    public Client(String lastName, String firstName, Address address, String email, String password, LocalDate birthDate, LocalDate registrationDate, List<String> licenseList, boolean desactivated) {
//        super(lastName, firstName, address, email, password);
//        this.birthDate = birthDate;
//        this.registrationDate = registrationDate;
//        this.licenseList = licenseList;
//        this.desactivated = desactivated;
//    }
//}
