package com.example.coffe.shop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.coffe.shop.dto.MenuDto;
import com.example.coffe.shop.service.MenuService;

@Controller
@RequiredArgsConstructor
@RequestMapping("sirenOrder")
public class OrderController {

    private final MenuService menuService;
    
    @GetMapping
    public String getMenuList(Model model) {
        List<MenuDto> list = menuService.findAll();
        model.addAttribute("list", list);
        return "sirenOrder";
    }
    
}
