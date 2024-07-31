package com.example.coffe.shop.controller;

import com.example.coffe.shop.dto.FileDto;
import com.example.coffe.shop.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriUtils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class FileController {

    private final FileService fileService;

    //업로드 뷰
    @GetMapping("/upload")
    public String testUploadForm() {
        return "uploadFile";
    }

    //업로드 post 메서드
    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("files") List<MultipartFile> files) throws IOException {

        Boolean dto = fileService.saveFile(file);
        log.info("uploadFile = {}", dto);

        for (MultipartFile multipartFile : files) {
            fileService.saveFile(multipartFile);
        }

        return "redirect:/view";
    }

    //업로드한 파일 목록 출력
    @GetMapping("/view")
    public String view(Model model) {
        List<FileDto> files = fileService.findAll();
        model.addAttribute("all",files);
        return "viewFile";
    }

    //   이미지 출력
    @GetMapping("/images/{fileId}")
    @ResponseBody
    public UrlResource downloadImage(@PathVariable("fileId") Long id, Model model) throws IOException{

        FileDto file = fileService.findById(id);
        return new UrlResource("file:" + file.getFileSavedPath());
    }

    // 첨부 파일 다운로드
    @GetMapping("/attach/{id}")
    public ResponseEntity<UrlResource> downloadAttach(@PathVariable Long id) throws MalformedURLException {

        FileDto file = fileService.findById(id);

        UrlResource resource = new UrlResource("file:" + file.getFileSavedPath());

        String encodedFileName = UriUtils.encode(file.getFileOrgNm(), StandardCharsets.UTF_8);

        // 파일 다운로드 대화상자가 뜨도록 하는 헤더를 설정해주는 것
        // Content-Disposition 헤더에 attachment; filename="업로드 파일명" 값을 준다.
        String contentDisposition = "attachment; filename=\"" + encodedFileName + "\"";

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,contentDisposition).body(resource);
    }


}
