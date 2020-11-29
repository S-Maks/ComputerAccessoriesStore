package com.computerAccessoriesStore.service.impl;

import com.computerAccessoriesStore.models.User;
import com.computerAccessoriesStore.repository.UserRepository;
import com.computerAccessoriesStore.service.UserService;
import com.computerAccessoriesStore.transfer.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void add(UserDTO dto){
        User user = User.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .username(dto.getUsername())
                .password(dto.getPassword())
                .email(dto.getEmail())
                .role(dto.getRole())
                .created_at(dto.getCreated_at())
                .build();
        userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

}
