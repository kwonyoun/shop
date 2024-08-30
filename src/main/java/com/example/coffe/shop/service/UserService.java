package com.example.coffe.shop.service;


import com.example.coffe.shop.dao.UsersRepository;
import com.example.coffe.shop.dto.Users;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserService {

    private final UsersRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    /* 회원가입 시, 유효성 체크 */
//    @Transactional(readOnly = true)
//    public Map<String, String> validateHandling(Errors errors) {
//        Map<String, String> validatorResult = new HashMap<>();
//        /* 유효성 검사에 실패한 필드 목록을 받음 */
//        for (FieldError error : errors.getFieldErrors()) {
//            String validKeyName = String.format("valid_%s", error.getField());
//            validatorResult.put(validKeyName, error.getDefaultMessage());
//        }
//        return validatorResult;
//    }

    public void save(Users dto){
        log.info("save = {}", dto);
        dto.setUserPw(bCryptPasswordEncoder.encode(dto.getUserPw()));
        dto.setRoles("USER");
        userRepository.save(dto);
    }

    public Boolean checkById(String userId){
        return userRepository.checkById(userId);
    }
}
