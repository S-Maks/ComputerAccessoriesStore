package com.computerAccessoriesStore.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {
    @GetMapping("/")
    public String mainPage(Authentication authentication) {
        if (authentication != null) {
            return "redirect:/home";
        }
        return "main/main";
    }

    @GetMapping("/signIn")
    public String loginPage(Authentication authentication, ModelMap model, HttpServletRequest request) {
        if (request.getParameterMap().containsKey("error")) {
            model.addAttribute("error", true);
        }
        if (authentication == null) {
            return "main/signIn";
        } else {
            return "redirect:/home";
        }

    }

    @GetMapping("/home")
    public String homePage() {
        return "main/home";
    }

}
