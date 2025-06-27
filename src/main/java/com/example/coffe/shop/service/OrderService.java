package com.example.coffe.shop.service;

import java.io.StringReader;
import java.util.List;

import com.example.coffe.shop.dto.CartItem;

public interface OrderService {
    /** 장바구니(cart)의 메뉴들을 실제 주문 테이블에 저장하고, 주문 PK를 반환한다. */
    Long placeOrder(String userId, List<CartItem> cart);
}
