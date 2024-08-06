package com.techlabs.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techlabs.model.FileMetadata;

public interface FileMetadataRepository extends JpaRepository<FileMetadata, Long> {
}