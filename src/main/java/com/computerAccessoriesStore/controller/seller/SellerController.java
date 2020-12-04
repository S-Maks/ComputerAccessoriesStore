package com.computerAccessoriesStore.controller.seller;

import com.computerAccessoriesStore.models.Act;
import com.computerAccessoriesStore.models.Product;
import com.computerAccessoriesStore.models.User;
import com.computerAccessoriesStore.service.ActService;
import com.computerAccessoriesStore.service.ProductService;
import com.computerAccessoriesStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ActService actService;

    @GetMapping(value = "/personalAccount")
    public String personalAccount(Model model){
        User seller = userService.getUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("seller",seller);
        return "seller/personalAccount";
    }

    @GetMapping(value = "/listProduct")
    public String sellersProducts(Model model){
        User seller = userService.getUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        List<Product> products= productService.findAllBySellerId(seller.getId());
        model.addAttribute("products", products);
        return "seller/listProduct";
    }

    @GetMapping(value = "/shopList")
    public String shopList(Model model){
        User seller = userService.getUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        List<Act> actList = actService.findAllBySellerId(seller.getId());
        model.addAttribute("acts",actList);
        return "seller/shopList";
    }
}
