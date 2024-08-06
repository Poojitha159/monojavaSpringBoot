package com.techlabs.app.service;

import com.techlabs.app.entity.FileItem;

import java.util.Optional;

public interface FileService {
    FileItem saveFile(FileItem file);

    Optional<FileItem> getFileByName(String fileName);
}