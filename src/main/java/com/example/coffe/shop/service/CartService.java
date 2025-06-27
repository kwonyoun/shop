package com.example.coffe.shop.service;

import java.util.List;

import com.example.coffe.shop.dto.CartItem;

public interface CartService {

        /** 장바구니 담기 */
    void addToCart(Long userId, Long menuId, int quantity);

    /** 장바구니 목록 조회 */
    List<CartItem> findCartItems(Long userId);

    /** 항목 1개 삭제 */
    void removeItem(Long userId, Long cartItemId);

    /** 장바구니 비우기 (주문 완료 등) */
    void clearCart(Long userId);
    
}
