package com.computerAccessoriesStore.controller.admin;

import com.computerAccessoriesStore.models.User;
import com.computerAccessoriesStore.service.UserService;
import com.computerAccessoriesStore.transfer.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(value = "/admin/showUser")
    public String showUserPage(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users",users);
        return "admin/showUser";
    }
}
