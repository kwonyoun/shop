package com.example.coffe.shop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.coffe.shop.service.MenuService;

@RestController
@RequestMapping("/admin")
public class AdminMenuController {

        private final MenuService menuService;

        public AdminMenuController(MenuService menuService) {
            this.menuService = menuService;
        }

        @GetMapping("/menu/load")
        public String loadMenu() {
            menuService.insertFromCsv("data/starbucks_menu_list.csv");
            return "메뉴 데이터 DB 저장 완료";
        }
    
}
