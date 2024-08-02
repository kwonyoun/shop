package com.example.coffe.shop.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Users {
    private String userId;
    private String userPw;
    private String roles;
}
