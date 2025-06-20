package com.example.coffe.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.example.coffe.shop.dto.StoreDto;

@Mapper
public interface StoreDao {
    List<StoreDto> findAll();
    void insertStoreList(StoreDto store);
}
