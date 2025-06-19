package com.example.coffe.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("trip")
@RequiredArgsConstructor
public class TripController {

    @GetMapping("yangyang")
    public String yangyang() {
        return "yangyang";
    }
    
    
}
