package com.computerAccessoriesStore.controller;

import com.computerAccessoriesStore.models.enums.Role;
import com.computerAccessoriesStore.service.UserService;
import com.computerAccessoriesStore.transfer.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.Calendar;

@Controller
public class SignUpController {

    @Autowired
    private UserService userService;

    @GetMapping("/signUp")
    public String registrationPage() {
        return "main/signUp";
    }

    @PostMapping("/signUp")
    public String registrationPage(@ModelAttribute UserDTO dto, BindingResult errors, Model model){
        dto.setRole(Role.ROLE_BUYER);
        dto.setCreated_at(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
        userService.add(dto);
        return "redirect:/signIn";
    }
}
