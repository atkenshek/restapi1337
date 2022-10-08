package com.example.restapi1337.service;

import com.example.restapi1337.entities.FileDb;
import com.example.restapi1337.utils.FileUploadUtil;
import com.example.restapi1337.repository.FileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileDbService {

    private final FileRepo fileRepo;

    @Autowired
    public FileDbService(FileRepo fileRepo) {
        this.fileRepo = fileRepo;
    }


    public String saveFile(MultipartFile multipartFile) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());

        String fileCode = FileUploadUtil.saveFile(fileName, multipartFile);

        FileDb fileDb = new FileDb();
        fileDb.setFileName(fileName);
        fileDb.setFileType(multipartFile.getContentType());
        fileDb.setUri("/downloadFile/" + fileCode);
        fileDb.setSize(multipartFile.getSize());
        fileDb.setData(multipartFile.getBytes());
        fileRepo.save(fileDb);
        return "URI of uploaded image: " + fileDb.getUri();
    }
}
