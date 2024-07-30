package com.example.coffe.shop.dao;

import com.example.coffe.shop.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardDao {
    List<BoardDto> findAll();
    boolean save(BoardDto board);
    BoardDto find(int board);

    boolean update(int boardId, String boardTitle, String boardContent);
}
