package com.computerAccessoriesStore.repository;

import com.computerAccessoriesStore.models.User;
import com.computerAccessoriesStore.transfer.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
}
