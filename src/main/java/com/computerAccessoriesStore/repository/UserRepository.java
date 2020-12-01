package com.computerAccessoriesStore.repository;

import com.computerAccessoriesStore.models.User;
import com.computerAccessoriesStore.transfer.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User,Long>{
}
