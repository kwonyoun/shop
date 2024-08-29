package com.example.coffe.shop.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

@Getter
@Setter
@Builder
public class Users {

    @Nullable
    private int userNo;

    @NotBlank(message = "아이디를 입력해주세요.")
    @Size(min = 2, max = 10, message = "아이디는 2자 이상 10자 이하로 입력해주세요.")
    private String userId;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Size(min = 8, max = 20, message = "비밀번호는 8자 이상 20자 이하로 입력해주세요.")
    private String userPw;

    private String roles;
}
