package com.example.coffe.shop.service;

import com.example.coffe.shop.dao.MenuDao;
import com.example.coffe.shop.dto.MenuDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    public MenuDao menuDao;

    public List<MenuDto> findAll() {
        return menuDao.findAll();
    }
}
