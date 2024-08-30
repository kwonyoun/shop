package com.example.coffe.shop.controller;

import com.example.coffe.shop.dto.Users;
import com.example.coffe.shop.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final UserService userService;

    @PostMapping("signup")
    public String signup(@Validated Users dto, Errors errors, Model model){

//        if (errors.hasErrors()) {/* 회원가입 실패시 입력 데이터 값을 유지 */
//            model.addAttribute("userDto", dto);
//            /* 유효성 통과 못한 필드와 메시지를 핸들링 */
//            Map<String, String> validatorResult = userService.validateHandling(errors);
//            for (String key : validatorResult.keySet()) {
//                model.addAttribute(key, validatorResult.get(key));
//                }/* 회원가입 페이지로 다시 리턴 */
//            return "/signup";
//        }
        log.info("signup = {}", dto);
        userService.save(dto);
        return "redirect:/login";
    }




}
