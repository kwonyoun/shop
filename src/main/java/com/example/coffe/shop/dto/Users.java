package com.example.coffe.shop.dto;

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
    private String userId;
    private String userPw;
    private String roles;
}
