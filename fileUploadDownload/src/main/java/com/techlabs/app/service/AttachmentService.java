package com.techlabs.app.service;

import org.springframework.web.multipart.MultipartFile;

import com.techlabs.app.entity.Attachment;

public interface AttachmentService {

	Attachment saveAttachment(MultipartFile file) throws Exception;

    Attachment getAttachment(String fileId) throws Exception;

}
