package com.product.project.entity;

import com.product.project.enums.Status;
import com.product.project.enums.Type;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;
    private String description;
    private String category;
    private String image;
    private int quantity;
    private double discount;
    @Enumerated(EnumType.STRING)
    private Type type;
    @Enumerated(EnumType.STRING)
    private Status status;
    @OneToOne(mappedBy="product",cascade = CascadeType.ALL)
    private Address manfactured_address;

}
