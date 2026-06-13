package com.product.project.entity;

import jakarta.persistence.Entity;


@Entity
public class Product {
    private int id;
    private String name;
    private double price;
    private String description;
    private String category;
    private String image;
    private int quantity;
    private double discount;
}
