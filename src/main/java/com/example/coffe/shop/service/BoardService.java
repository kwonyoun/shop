package com.example.coffe.shop.service;

import com.example.coffe.shop.dao.BoardDao;
import com.example.coffe.shop.dto.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardDao boardDao;

    //게시글 전체 출력
    public List<BoardDto> findAll() {
        return boardDao.findAll();
    }

    //게시글 저장
    public boolean save(BoardDto board){
        return  boardDao.save(board);
    }

    //게시글 출력
    public BoardDto find(int board) {return  boardDao.find(board); }

    //게시글 수정
    public boolean update(int id, String title, String cont){ return  boardDao.update(id, title, cont); }

    //게시글 삭제
    public boolean delete(int id){ return  boardDao.delete(id); }
}
