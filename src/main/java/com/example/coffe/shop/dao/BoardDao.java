package com.example.coffe.shop.dao;

import com.example.coffe.shop.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardDao {
    //모든 게시글 출력
    List<BoardDto> findAll();
    boolean save(BoardDto board);
    //선택 게시글 출력
    BoardDto find(int board);

    boolean update(int boardId, String boardTitle, String boardContent);

    boolean delete(int boardId);
}
