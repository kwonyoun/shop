package com.example.coffe.shop.security;

import com.example.coffe.shop.dao.UsersRepository;
import com.example.coffe.shop.dto.Users;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsersRepository usersRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("loadUserByUserame = {}", username);
        Optional<Users> findOne  = Optional.ofNullable(usersRepository.findByUserId(username));
        Users member = findOne.orElseThrow(() -> new UsernameNotFoundException("없는 회원"));
        return User.builder()
                .username(member.getUserId())
                .password(member.getUserPw())
                .roles(member.getRoles())
                .build();
    }
}
