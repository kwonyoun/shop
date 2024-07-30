package com.example.coffe.shop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDto {

    private int boardId;
    private String boardTitle;
    private String boardContent;
    private String boardWriter;
    private String BoardView;
    private String boardDate;
}
