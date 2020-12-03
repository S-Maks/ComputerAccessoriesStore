package com.computerAccessoriesStore.service;

import com.computerAccessoriesStore.models.Act;
import com.computerAccessoriesStore.models.Product;
import com.computerAccessoriesStore.transfer.ActDTO;
import com.computerAccessoriesStore.transfer.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface ActService {
    List<Act> findAll();

    void add(ActDTO dto);

    void deleteById(Long id);

    Optional<Act> getById(Long id);

    void edit(ActDTO dto);
}
