package com.techlabs.app.entity;

import java.nio.file.Files;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<Files, Long> {

	Files findByName(String name);
}
