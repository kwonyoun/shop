package com.example.coffe.shop.controller;


import com.example.coffe.shop.dto.BoardDto;
import com.example.coffe.shop.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("board")
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    private final BoardService boardService;

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

    @GetMapping("{boardId}")
    public String boardView(@PathVariable("boardId") int boardId, Model model ){
        BoardDto board = boardService.find(boardId);
        log.info("boardView = {}", board);
        model.addAttribute("board", board);
        return "board";
    }

    @GetMapping("{boardId}/edit")
    public String editForm(@PathVariable("boardId") int boardId, Model model){
        BoardDto board = boardService.find(boardId);
        log.info("boardView = {}", board);
        model.addAttribute("board", board);
        return "boardEditForm";
    }

    @PostMapping("{boardId}/edit")
    public String updateForm(@PathVariable("boardId") int boardId, BoardDto board){
        log.info("updateForm = {}", board.getBoardTitle());
        boolean updated = boardService.update(boardId, board.getBoardTitle(), board.getBoardContent());
        if (updated) {
            return "redirect:/board/{boardId}";
        } else {
            return "redirect:/board/{boardId}/edit?error=true";
        }
    }

    @GetMapping("{boardId}/delete")
    public String deleteform(@PathVariable("boardId") int boardId){
        boolean delete = boardService.delete(boardId);
        log.info("deleteform = {}", delete);
        if (delete) {
            return "redirect:/board";
        } else {
            return "redirect:/board/{boardId}/delete?error=true";
        }

    }
}
