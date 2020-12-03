package com.computerAccessoriesStore.repository;

import com.computerAccessoriesStore.models.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository  extends JpaRepository<CreditCard, Long> {
}
