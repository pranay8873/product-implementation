package com.product.project.dto;

import com.product.project.enums.Status;
import com.product.project.enums.Type;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class ProductUpdateDto {
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
}
