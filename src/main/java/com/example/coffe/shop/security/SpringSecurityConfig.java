package com.example.coffe.shop.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/", "/login", "/signup").permitAll()
                        .anyRequest().authenticated()
                )
				.formLogin(formLogin -> formLogin
						.loginPage("/login")
                        .loginProcessingUrl("/login-process")
                        .usernameParameter("username")
                        .passwordParameter("password")
						.defaultSuccessUrl("/", true))
                .logout((logout) -> logout
                        .logoutSuccessHandler((request, response, authentication) -> {
                            response.sendRedirect("/");
                        }) // 로그아웃 성공 핸들러
                        .deleteCookies("remember-me") // 로그아웃 후 삭제할 쿠키 지정
                        );

        return http.build();
    }

    // 패스워드 인코더로 사용할 빈 등록
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}