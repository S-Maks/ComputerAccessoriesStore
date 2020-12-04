package com.computerAccessoriesStore.repository;

import com.computerAccessoriesStore.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    User getByUsername(String username);
    List<User> findAllByRole_RoleSellerContains();
}
