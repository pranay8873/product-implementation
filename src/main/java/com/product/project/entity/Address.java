package com.product.project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String doorNo;
    private String street;
    private String city;
    private String state;
    private String country;
    private String pincode;
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

}
