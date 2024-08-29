package com.example.coffe.shop.controller;

import com.example.coffe.shop.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("check")
public class CheckController {

    private final UserService userService;

    @GetMapping("sendId/{userId}")
    public ResponseEntity<Boolean> checkById(@PathVariable String userId){
        Boolean isAvailable = userService.checkById(userId);
        log.info("checkId = {}", isAvailable);

        return ResponseEntity.ok(isAvailable);
    }
}
