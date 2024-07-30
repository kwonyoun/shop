package com.example.coffe.shop.controller;


import com.example.coffe.shop.dto.BoardDto;
import com.example.coffe.shop.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("board")
@Slf4j
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping
    public String board(Model model){
        List<BoardDto> list = boardService.findAll();
        model.addAttribute("list", list);
        return "boardlist";
    }

    @GetMapping("addForm")
    public String addFormView(Model model){
        model.addAttribute("board", new BoardDto());
        return "boardAddForm";
    }

    @PostMapping("addForm")
    public String addForm(BoardDto board){
        log.info("addForm = {}", board.toString());
        Boolean s = boardService.save(board);
        log.info("save = {}", s);
        return "redirect:/board";
    }
}
