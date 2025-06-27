package com.example.coffe.shop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemDto {
    private Long orderItemId;  // PK
    private Long orderId;      // FK → orders.order_id
    private Long menuId;       // FK → menu.menu_id
    private int  quantity;
    private int  price;        // 단가 * quantity
    
}
