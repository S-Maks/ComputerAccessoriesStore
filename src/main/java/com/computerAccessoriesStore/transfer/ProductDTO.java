package com.computerAccessoriesStore.transfer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Data
@AllArgsConstructor
@Builder
@EnableJpaRepositories("com.computerAccessoriesStore.*")
public class ProductDTO {

    private Long id;
    private String productName;
    private Long productCost;
}
