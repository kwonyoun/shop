package com.example.coffe.shop.dao;

import com.example.coffe.shop.dto.CartItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CartMapper {

    void insert(@Param("userId") Long userId,
                @Param("menuId") Long menuId,
                @Param("quantity") int quantity);

    CartItem findByUserAndMenu(@Param("userId") Long userId,
                               @Param("menuId") Long menuId);

    List<CartItem> findByUserId(Long userId);

    void updateQuantity(@Param("id") Long id,
                        @Param("quantity") int quantity);

    void deleteByIdAndUser(@Param("id") Long id,
                           @Param("userId") Long userId);

    void deleteAllByUser(Long userId);
}