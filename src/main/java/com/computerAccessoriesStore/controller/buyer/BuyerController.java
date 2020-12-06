package com.computerAccessoriesStore.controller.buyer;

import com.computerAccessoriesStore.models.*;
import com.computerAccessoriesStore.service.*;
import com.computerAccessoriesStore.transfer.ActDTO;
import com.computerAccessoriesStore.transfer.CommentDTO;
import com.computerAccessoriesStore.transfer.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Stream;

@Controller
@RequestMapping("/buyer")
public class BuyerController {

    @Autowired
    private ActService actService;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private CreditCardService creditCardService;

    @GetMapping("/buyProduct")
    public String buyProduct(@RequestParam(value = "id", required = true) Long id, Model model) {
        Optional<Product> product = productService.getById(id);
        ProductDTO productDTO = ProductDTO.builder()
                .id(product.get().getId())
                .product_cost(product.get().getProduct_cost())
                .product_name(product.get().getProduct_name())
                .idSeller(product.get().getSeller().getId())
                .build();
        model.addAttribute("product", productDTO);
        User buyer = userService.getUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("buyer", buyer);
        model.addAttribute("seller", product.get().getSeller());
        return "buyer/buyProduct";
    }

    @PostMapping(value = "/buyProduct")
    public String buyProduct(@ModelAttribute ActDTO dto, Model model) {
        actService.add(dto);
        return "redirect:/product/showProduct";
    }

    @GetMapping(value = "/personalAccount")
    public String personalAccount(Model model) {
        User buyer = userService.getUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        List<CreditCard> creditCard = creditCardService.findAllByBuyerId(buyer.getId());
        System.out.println(creditCard.get(0).getBalance());

        model.addAttribute("card",creditCard.get(0).getBalance());
        model.addAttribute("buyer", buyer);
        return "buyer/personalAccount";
    }

    @GetMapping(value = "/shopList")
    public String shopList(Model model) {
        User buyer = userService.getUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        List<Act> actList = actService.findAllByBuyer(buyer.getId());
        model.addAttribute("acts", actList);
        return "buyer/shopList";
    }

    @GetMapping(value = "/listSellers")
    public String listSellers(@RequestParam(value = "search", required = false, defaultValue = "") String name, Model model) {
        List<User> sellers = userService.findAllBySellerInfoByParam(name);
        model.addAttribute("sellers", sellers);
        return "buyer/listSellers";
    }

    @GetMapping(value = "/leaveComment")
    public String leaveComment(@RequestParam(value = "id", required = true) Long id, Model model) {
        Optional<User> seller = userService.getById(id);
        model.addAttribute("idSeller", seller.get().getId());
        User buyer = userService.getUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("idBuyer", buyer.getId());
        return "buyer/leaveComment";
    }

    @PostMapping(value = "/leaveComment")
    public String leaveComment(@ModelAttribute CommentDTO dto, Model model) {
        commentService.add(dto);
        return "redirect:/buyer/listSellers";
    }

    @GetMapping(value = "/showRating")
    public String showRating(@RequestParam(value = "id", required = true) Long id, Model model) {
        List<Comment> comments = commentService.getCommentSellerBySortDate(id);
        OptionalDouble rating = comments.stream().mapToDouble(e->e.getRating()).average();
        Optional<User> user = userService.getById(id);
        model.addAttribute("user",user.get());
        model.addAttribute("comments", comments);
        model.addAttribute("average",new java.text.DecimalFormat("0.00").format( rating.getAsDouble() ));
        return "buyer/showRating";
    }
}
