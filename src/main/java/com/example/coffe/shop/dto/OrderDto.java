package com.example.coffe.shop.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class OrderDto {
    private Long orderId;          // PK (auto-increment)
    private String userId;           // 누가 주문했는지
    private LocalDateTime orderAt; // 주문 시각
    private int totalPrice;        // 합계 금액
    
}
