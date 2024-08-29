package com.example.coffe.shop.service;


import com.example.coffe.shop.dao.UsersRepository;
import com.example.coffe.shop.dto.Users;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserService {

    private final UsersRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

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
