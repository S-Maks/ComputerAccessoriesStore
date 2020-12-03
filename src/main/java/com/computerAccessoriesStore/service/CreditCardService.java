package com.computerAccessoriesStore.service;

import com.computerAccessoriesStore.models.CreditCard;
import com.computerAccessoriesStore.models.Product;
import com.computerAccessoriesStore.transfer.CreditCardDTO;
import com.computerAccessoriesStore.transfer.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface CreditCardService {
    List<CreditCard> findAll();

    void add(CreditCardDTO dto);

    void deleteById(Long id);

    Optional<CreditCard> getById(Long id);

    void edit(CreditCardDTO dto);
}
