package com.example.coffe.shop.controller;

import com.example.coffe.shop.dto.MenuDto;
import com.example.coffe.shop.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@Slf4j
public class MenuController {

    @Autowired
    MenuService menuService;

    @GetMapping("menu")
    String menu(Model model){
        List<MenuDto> list = menuService.findAll();
        model.addAttribute("list", list);
        return "menu";
    }

}
