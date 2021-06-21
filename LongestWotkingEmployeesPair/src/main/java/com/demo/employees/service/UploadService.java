package com.demo.employees.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
    public String uploadFile(MultipartFile file, String UPLOAD_DIR) throws IOException;
}
