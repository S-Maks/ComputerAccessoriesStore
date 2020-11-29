package com.computerAccessoriesStore.service;

import com.computerAccessoriesStore.models.User;
import com.computerAccessoriesStore.transfer.UserDTO;

import java.util.List;

public interface UserService {
    void add(UserDTO dto);
    List<User> findAll();
}
