package com.example.restapi1337.controller;

import com.example.restapi1337.service.FileDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class FileController {

    private final FileDbService fileDbService;

    @Autowired
    public FileController(FileDbService fileDbService) {
        this.fileDbService = fileDbService;
    }

    @PostMapping("api/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException{
        String fileURI = fileDbService.saveFile(file);
        return ResponseEntity.ok(fileURI);
    }
}
