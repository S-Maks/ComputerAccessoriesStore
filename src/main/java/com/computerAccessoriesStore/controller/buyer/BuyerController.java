package com.computerAccessoriesStore.controller.buyer;

import com.computerAccessoriesStore.models.Product;
import com.computerAccessoriesStore.models.User;
import com.computerAccessoriesStore.repository.UserRepository;
import com.computerAccessoriesStore.service.ActService;
import com.computerAccessoriesStore.service.ProductService;
import com.computerAccessoriesStore.service.UserService;
import com.computerAccessoriesStore.transfer.ActDTO;
import com.computerAccessoriesStore.transfer.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/buyer")
public class BuyerController {

    @Autowired
    private ActService actService;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @GetMapping("/buyProduct")
    public String buyProduct(@RequestParam(value = "id", required = true) Long id, Model model){
        Optional<Product> product = productService.getById(id);
        ProductDTO productDTO = ProductDTO.builder()
                .id(product.get().getId())
                .product_cost(product.get().getProduct_cost())
                .product_name(product.get().getProduct_name())
                .idSeller(product.get().getUser().getId())
                .build();
        model.addAttribute("product", productDTO);
        User buyer = userService.getUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("buyer",buyer);
        model.addAttribute("seller",product.get().getUser());
        return "buyer/buyProduct";
    }

    @RequestMapping(value = "/buyProduct", method = RequestMethod.POST)
    public String buyProduct(@ModelAttribute ActDTO dto, Model model){
        actService.add(dto);
        return "redirect:/product/showProduct";
    }
}
