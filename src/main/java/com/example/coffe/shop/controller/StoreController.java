package com.example.coffe.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.coffe.shop.dto.StoreDto;
import com.example.coffe.shop.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("store")
public class StoreController {

        private final StoreService storeService;

        @Value("${kakao.javascript.key}")
        private String kakaoKey;

        @GetMapping
        public String getStoreList(Model model) {
            List<StoreDto> list = storeService.findAll();
            model.addAttribute("list", list);
            return "store";
        }

        @GetMapping("map")
        public String getStoreMap(Model model) {
            model.addAttribute("kakaoKey", kakaoKey);
            return "storeMap";
        }
        
        
    
}
