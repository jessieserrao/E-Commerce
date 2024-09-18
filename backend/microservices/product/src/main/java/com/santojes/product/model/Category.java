package com.santojes.product.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    /**
     * CascadeType - When we perform some action on the target entity, the same action will be applied to the associated entity.
     */
    @OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE)
    @Column(name = "products")
    private List<Product> products;


}
