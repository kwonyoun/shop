package com.example.coffe.shop.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.coffe.shop.dto.StoreDto;
import com.example.coffe.shop.service.StoreService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api")
public class ApiController {
    
    private final StoreService storeService;

    @GetMapping("stores")
    public List<StoreDto> getStores() {
        return storeService.findAll();
    }
}
