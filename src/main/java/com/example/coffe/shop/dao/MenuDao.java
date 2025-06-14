package com.example.coffe.shop.dao;

import com.example.coffe.shop.dto.MenuDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuDao {
    List<MenuDto> findAll();
    void insertMenu(MenuDto menu);
}
