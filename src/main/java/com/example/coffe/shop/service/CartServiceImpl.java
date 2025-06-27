package com.example.coffe.shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.coffe.shop.dao.CartMapper;
import com.example.coffe.shop.dto.CartItem;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CartServiceImpl implements CartService {

    private final CartMapper cartMapper;

    @Override
    public void addToCart(Long userId, Long menuId, int quantity) {
        CartItem existing = cartMapper.findByUserAndMenu(userId, menuId);
        if (existing == null) {
            cartMapper.insert(userId, menuId, quantity);
        } else {
            cartMapper.updateQuantity(existing.getId(), existing.getQuantity() + quantity);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<CartItem> findCartItems(Long userId) {
        return cartMapper.findByUserId(userId);
    }

    @Override
    public void removeItem(Long userId, Long cartItemId) {
        cartMapper.deleteByIdAndUser(cartItemId, userId);
    }

    @Override
    public void clearCart(Long userId) {
        cartMapper.deleteAllByUser(userId);
    }
}