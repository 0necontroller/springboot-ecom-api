package com.onecontroller.ecommerce.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String brand;
    private String name;
    private BigDecimal price;
    private Integer inventory;
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Image> images;

    public Product(String brand, String name, BigDecimal price, Integer inventory, String description, Category category) {
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.inventory = inventory;
        this.description = description;
        this.category = category;
    }
}
