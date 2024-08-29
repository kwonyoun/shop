package com.example.coffe.shop.controller;

import com.example.coffe.shop.dto.Users;
import com.example.coffe.shop.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final UserService userService;

    @PostMapping("signup")
    public String signup(@Validated Users dto){
        log.info("signup = {}", dto);
        userService.save(dto);
        return "home";
    }




}
