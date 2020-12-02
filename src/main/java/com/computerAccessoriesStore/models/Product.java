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
    @JoinColumn(name = "idProduct")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    Float product_cost;

    String product_name;

    /*@Column(name = "idseller")
    Long idSeller;*/

    @ManyToOne
    @JoinColumn(name="idSeller")
    private User user;

}
