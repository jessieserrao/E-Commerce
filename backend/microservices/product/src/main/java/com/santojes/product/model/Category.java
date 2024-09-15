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
public class Category {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String description;

    /**
     * CascadeType - When we perform some action on the target entity, the same action will be applied to the associated entity.
     */
    @OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE)
    private List<Product> products;


}
