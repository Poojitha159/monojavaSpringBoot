package com.techlabs.app.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.techlabs.app.entity.Attachment;
import com.techlabs.app.repository.AttachmentRepository;

import io.micrometer.common.util.StringUtils;

@Service
public class AttachmentServiceImpl implements AttachmentService{

	private AttachmentRepository attachmentRepository  ;
	
	
	
	public AttachmentServiceImpl(AttachmentRepository attachmentRepository) {
		super();
		this.attachmentRepository = attachmentRepository;
	}
	@Override
    public Attachment saveAttachment(MultipartFile file) throws Exception {
       String fileName = StringUtils.cleanPath(file.getOriginalFilename());
       try {
            if(fileName.contains("..")) {
                throw  new Exception("Filename contains invalid path sequence "
                + fileName);
            }

            Attachment attachment
                    = new Attachment(fileName,
                    file.getContentType(),
                    file.getBytes());
            return attachmentRepository.save(attachment);

       } catch (Exception e) {
            throw new Exception("Could not save File: " + fileName);
       }
    }

    @Override
    public Attachment getAttachment(String fileId) throws Exception {
        return attachmentRepository
                .findById(fileId)
                .orElseThrow(
                        () -> new Exception("File not found with Id: " + fileId));
    }
}