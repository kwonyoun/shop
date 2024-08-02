package com.example.coffe.shop.dao;

import com.example.coffe.shop.dto.Users;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UsersRepository {

    Users findByUserId(String userId);
    void save(Users user);

}
