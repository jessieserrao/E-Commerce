package com.santojes.product.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@Entity
@Builder
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "available_quantity")
    private double availableQuantity;

    @Column(name = "price")
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

}
