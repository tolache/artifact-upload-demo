package com.example.artifactuploaddemo.server;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class ArtifactUploadController {

    @Value("${file.upload-dir}")
    private String uploadDir;

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            File dest = new File(uploadDir + File.separator + file.getOriginalFilename());
            file.transferTo(dest);
            return "File uploaded successfully: " + dest.getAbsolutePath();
        } catch (IOException e) {
            return "File upload failed: " + e.getMessage();
        }
    }
}