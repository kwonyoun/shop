package com.example.coffe.shop.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.coffe.shop.dto.OrderDto;
import com.example.coffe.shop.dto.OrderItemDto;

@Mapper
public interface OrderMapper {
    void insertOrder(OrderDto order);
    void updateTotalPrice(@Param("orderId") Long orderId,
                          @Param("total") int total);

    // 주문 상세
    void insertOrderItem(OrderItemDto item);
    
}
