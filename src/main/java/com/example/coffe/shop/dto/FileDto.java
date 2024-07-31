package com.example.coffe.shop.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FileDto {

    private Long fileId;

    private String fileOrgNm;

    private String fileSavedNm;

    private String fileSavedPath;
}
