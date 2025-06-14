// package com.example.coffe.shop.component;

// import org.springframework.boot.CommandLineRunner;
// import org.springframework.stereotype.Component;

// import com.example.coffe.shop.service.MenuService;

/*
 * 이 파일은 @Component로 등록하여 SpringBoot 실행 시 작동됨.
 * 매번 크롤링 할 필요가 없다 생각하여 Controller로 설정했다.
 */
// @Component
// public class CsvMenuLoader implements CommandLineRunner {

//     private final MenuService menuService;

//     public CsvMenuLoader(MenuService menuService) {
//         this.menuService = menuService;
//     }

//     @Override
//     public void run(String... args) {
//         menuService.insertFromCsv("./component/starbucks-menu.csv");
//     }
// }