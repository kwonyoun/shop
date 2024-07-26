package com.example.coffe.shop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class HomeController {

    @GetMapping
    public String index(Model model){
        model.addAttribute("data", "hello?");
        return "home";
    }
}