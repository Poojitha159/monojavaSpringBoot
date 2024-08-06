package com.techlabs.app.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;



@Service
public class FileStorageService 
{
	@Value("${file.storage.location}")
private String fileStorageLocation;

public String storeFile(MultipartFile file) {
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());

    try {
        // Create the storage directory if it does not exist
        Path storagePath = Paths.get(fileStorageLocation).toAbsolutePath().normalize();
        Files.createDirectories(storagePath);

        // Copy the file to the target location
        Path targetLocation = storagePath.resolve(fileName);
        Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

        return fileName;
    } catch (IOException e) {
        throw new RuntimeException("Could not store file " + fileName + ". Please try again!", e);
    }
}

public Resource loadFileAsResource(String fileName) {
    try {
        Path filePath = Paths.get(fileStorageLocation).resolve(fileName).normalize();
        Resource resource = new FileSystemResource(filePath.toFile());

        if (resource.exists()) {
            return resource;
        } else {
            throw new RuntimeException("File not found " + fileName);
        }
    } catch (Exception e) {
        throw new RuntimeException("File not found " + fileName, e);
    }
}

public String getFileStorageLocation() {
    return fileStorageLocation;
}
}


