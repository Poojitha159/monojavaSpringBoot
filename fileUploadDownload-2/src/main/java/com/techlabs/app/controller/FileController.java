package com.techlabs.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpHeaders;

import com.techlabs.app.repository.FileMetadataRepository;
import com.techlabs.app.service.FileStorageService;
import com.techlabs.model.FileMetadata;

import org.springframework.core.io.Resource;
@RestController
@RequestMapping("/files")
public class FileController {

	
	@Autowired
	private FileStorageService fileStorageService;

	@Autowired
	private FileMetadataRepository fileMetadataRepository;

	@PostMapping("/upload")
	public String uploadFile(@RequestParam("file") MultipartFile file) {
		String fileName = fileStorageService.storeFile(file);
		// Save metadata to database
		FileMetadata metadata = new FileMetadata();
		metadata.setFileName(fileName);
		metadata.setFilePath(fileStorageService.getFileStorageLocation() + "/" + fileName);
		fileMetadataRepository.save(metadata);

		return "File uploaded successfully: " + fileName;
	}

	@GetMapping("/download/{fileName:.+}")
	public ResponseEntity<jakarta.annotation.Resource> downloadFile(@PathVariable String fileName) {
		jakarta.annotation.Resource resource = (jakarta.annotation.Resource) fileStorageService.loadFileAsResource(fileName);

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + ((Resource) resource).getFilename() + "\"")
				.body(resource);
	}

	@GetMapping("/metadata")
	public List<FileMetadata> getFileMetadata() {
		return fileMetadataRepository.findAll();
	}
}

