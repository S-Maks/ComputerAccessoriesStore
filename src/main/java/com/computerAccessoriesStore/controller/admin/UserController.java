package com.computerAccessoriesStore.controller.admin;

import com.computerAccessoriesStore.models.User;
import com.computerAccessoriesStore.models.enums.Role;
import com.computerAccessoriesStore.service.UserService;
import com.computerAccessoriesStore.transfer.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(value = "/showUser")
    public String showUserPage(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users",users);
        return "admin/showUser";
    }
    @GetMapping(value = "/findUser")
    public String findUser(@RequestParam(value = "search", required = false, defaultValue = "") String name, Model model){
        List<User>findUser =userService.getSellersGeneralInfoByParam(name);
        model.addAttribute("result", findUser);
        model.addAttribute("search", name);
        return "admin/findUser";
    }
    @GetMapping(value = "/editUser")
    public String editUser(@RequestParam(value = "id", required = true) Long id, Model model){
        Optional<User> dto = userService.getById(id);
        model.addAttribute("user", dto.get());
        return "admin/editUser";
    }

    @RequestMapping(value="/editUser", method = RequestMethod.POST)
    public String editSeller(@ModelAttribute UserDTO dto, BindingResult errors, Model model) throws Exception {
        userService.edit(dto);
        return "redirect:/admin/showUser";
    }

    @GetMapping(value = "/deleteUser")
    public String deleteUser(@RequestParam (value = "id", required = false) Long id,  Model model){
        if(id != null){
            userService.deleteById(id);
        }
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "admin/deleteUser";
    }

    @GetMapping(value = "/blockUser")
    public String blockUser(@RequestParam (value = "id", required = false)Long id,  Model model){
        if(id!=null){
            User user = Optional.of(userService.getById(id)).get().get();
            UserDTO dto = UserDTO.builder()
                    .id(user.getId())
                    .firstName(user.getFirstName())
                    .lastName(user.getLastName())
                    .email(user.getEmail())
                    .password(user.getPassword())
                    .created_at(user.getCreated_at())
                    .username(user.getUsername())
                    .role(user.getRole())
                    .build();
            if(dto.getRole()==Role.ROLE_BLOCKED){
                dto.setRole(Role.ROLE_BUYER);
            }else{
                dto.setRole(Role.ROLE_BLOCKED);
            }
            userService.edit(dto);
        }
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "admin/blockUser";
    }
}
