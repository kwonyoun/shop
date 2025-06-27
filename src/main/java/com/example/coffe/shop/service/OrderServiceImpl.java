package com.example.coffe.shop.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.coffe.shop.dao.OrderMapper;
import com.example.coffe.shop.dto.CartItem;
import com.example.coffe.shop.dto.OrderDto;
import com.example.coffe.shop.dto.OrderItemDto;

import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;

    @Override
    public Long placeOrder(String userId, List<CartItem> cart) {
        // 1) 주문(orders) 레코드 먼저 insert — PK(order_id) 확보
        OrderDto order = new OrderDto();
        order.setUserId(userId);
        order.setOrderAt(LocalDateTime.now());
        orderMapper.insertOrder(order); // <selectKey> 로 orderId 자동 세팅

        int total = 0;

        // 2) 주문 상세(order_items) 저장
        for (CartItem c : cart) {
            // 수량: cart에 없다면 1로 가정
            int lineTotal = c.getPrice() * c.getQuantity();

            OrderItemDto item = new OrderItemDto();
            item.setOrderId(order.getOrderId());
            item.setMenuId(c.getId());
            item.setQuantity(c.getQuantity());
            item.setPrice(lineTotal);
            orderMapper.insertOrderItem(item);

            total += lineTotal;
        }

        // 3) 최종 합계 금액을 orders 테이블에 반영
        orderMapper.updateTotalPrice(order.getOrderId(), total);

        return order.getOrderId();
    }
    
}
