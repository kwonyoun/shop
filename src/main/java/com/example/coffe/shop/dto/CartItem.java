package com.example.coffe.shop.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CartItem {
    private Long id;
    private Long userId;
    private Long menuId;
    private int price;
    private int  quantity;
    private LocalDateTime regDate;
}