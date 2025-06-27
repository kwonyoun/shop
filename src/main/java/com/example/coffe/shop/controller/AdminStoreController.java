package com.example.coffe.shop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.coffe.shop.service.StoreService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor

public class AdminStoreController {

    private final StoreService storeService;
    
    @GetMapping("/store/load")
    public String loadStore() {
        storeService.insertStoreList("data/all_starbucks_store_list.csv");
        return "Store list DB 저장 완료";
    }
    
}
