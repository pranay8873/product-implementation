package com.product.project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Address {
    @Id
    private int id;
    private String doorNo;
    private String street;
    private String city;
    private String state;
    private String country;
    private String pincode;
}
