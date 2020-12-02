package com.computerAccessoriesStore.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "product",schema = "public", catalog = "ComputerAccessoriesStore")
public class Product {
    @Id
    @Column(name = "idproduct")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Float product_cost;

    String product_name;

    @ManyToOne
    @JoinColumn(name="idseller")
    private User user;

}
