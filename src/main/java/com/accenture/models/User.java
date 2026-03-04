//package com.accenture.models;
//
//import jakarta.persistence.*;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.UUID;
//
//@Entity(name = "UserEntity")
//@NoArgsConstructor
//@Data
//@Table(name = "USER")
//public abstract class User {
//
//    private UUID id;
//
//    private String lastName;
//    private String firstName;
//    private Address address;
//    private String email;
//    private String password;
//
//    public User(String lastName, String firstName, Address address, String email, String password) {
//        this.lastName = lastName;
//        this.firstName = firstName;
//        this.address = address;
//        this.email = email;
//        this.password = password;
//    }
//
//    public User(String lastName, String firstName, String email, String password) {
//        this.lastName = lastName;
//        this.firstName = firstName;
//        this.email = email;
//        this.password = password;
//    }
//}
