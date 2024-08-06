package com.techlabs.app.services;

import java.util.Optional;

import org.apache.tomcat.util.http.fileupload.FileItem;

public class FileServiceImpl implements FileService{

	private FileRepository repository;

	public FileServiceImpl(FileRepository repository) {
		super();
		this.repository = repository;
	}
	
	@Override
	public FileItem saveFile(FileItem file) {
		return repository.save(file);
	}
	
	@Override
	public Optional<FileItem> getFileName(String fileName){
		Optional<FileItem>item=repository.findByname(filename);
		return item;
	}
}
