package com.computerAccessoriesStore.repository;

import com.computerAccessoriesStore.models.Act;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActRepository extends JpaRepository<Act, Long> {
}
