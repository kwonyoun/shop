package com.example.coffe.shop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.coffe.shop.dto.CartItem;
import com.example.coffe.shop.dto.MenuDto;
import com.example.coffe.shop.dto.Users;
import com.example.coffe.shop.service.MenuService;
import com.example.coffe.shop.service.OrderService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {

    private final MenuService menuService;
    private final OrderService orderService;

    @PostMapping("/add")
    public String addToCart(@RequestParam Long menuId, HttpSession session) {
        MenuDto menu = menuService.findById(menuId);

        // 세션에서 장바구니 가져오기
        List<MenuDto> cart = (List<MenuDto>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }

        cart.add(menu);
        session.setAttribute("cart", cart);

        return "redirect:/cart"; // 장바구니 페이지로 이동
    }

    @GetMapping
    public String viewCart(HttpSession session, Model model) {
        List<MenuDto> cart = (List<MenuDto>) session.getAttribute("cart");
        if (cart == null) cart = new ArrayList<>();

        model.addAttribute("cartList", cart);
        return "cart"; // cart.html로 장바구니 보여주기
    }

    @PostMapping("/remove")
    public String removeFromCart(@RequestParam int index, HttpSession session) {
        List<MenuDto> cart = (List<MenuDto>) session.getAttribute("cart");
        if (cart != null && index < cart.size()) {
            cart.remove(index);
        }
        return "redirect:/cart";
    }

    @PostMapping("/checkout")
    public String checkout(HttpSession session, @AuthenticationPrincipal User user) {
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart != null && !cart.isEmpty()) {
            // 주문 로직 처리
            orderService.placeOrder(user.getUsername(),cart);

            // 장바구니 초기화
            session.removeAttribute("cart");
        }
        return "redirect:/menu"; // 혹은 주문 완료 페이지
    }
    
}
