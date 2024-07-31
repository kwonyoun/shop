package com.example.coffe.shop.dao;

import com.example.coffe.shop.dto.FileDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileDao {

    boolean save(FileDto fileDto);
    List<FileDto> findAll();

    FileDto findById(Long fileId);
}
