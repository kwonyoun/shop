package com.example.coffe.shop.service;

import com.example.coffe.shop.dao.FileDao;
import com.example.coffe.shop.dto.FileDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class FileService {

    @Value("${file.dir}")
    private String fileDir;

    private final FileDao fileDao;

    //파일 저장
    public Boolean saveFile(MultipartFile files) throws IOException {

        if (files.isEmpty()) {
            return null;
        }

        // 원래 파일 이름 추출
        String origName = files.getOriginalFilename();

        // 파일 이름으로 쓸 uuid 생성
        String uuid = UUID.randomUUID().toString();

        // 확장자 추출(ex : .png)
        assert origName != null;
        String extension = origName.substring(origName.lastIndexOf("."));

        // uuid와 확장자 결합
        String savedName = uuid + extension;

        // 파일을 불러올 때 사용할 파일 경로
        String savedPath = fileDir + savedName;

        // 파일 엔티티 생성
        FileDto file = FileDto.builder()
                .fileOrgNm(origName)
                .fileSavedNm(savedName)
                .fileSavedPath(savedPath)
                .build();

        // 실제로 로컬에 uuid를 파일명으로 저장
        files.transferTo(new File(savedPath));

        // 데이터베이스에 파일 정보 저장
        Boolean savedFile = fileDao.save(file);

        return savedFile;
    }

    //저장된 파일들 출력
    public List<FileDto> findAll(){
        return fileDao.findAll();
    }

    //이미지 출력
    public FileDto findById(Long fileId){
        return fileDao.findById(fileId);
    }


}
