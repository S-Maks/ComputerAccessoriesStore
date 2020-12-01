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
@Table(name = "Product",schema = "public", catalog = "ComputerAccessoriesStore")
public class Product {
    @Id
    @Column(name="idproduct")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Float product_cost;

    String product_name;

    /*@Column(name = "idseller")
    Long idSeller;*/

    @ManyToOne
    @JoinColumn(name="idseller")
    private User user;

}
