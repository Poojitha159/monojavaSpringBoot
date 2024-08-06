package com.techlabs.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import java.io.File;
import java.nio.file.AccessDeniedException;
@Service
public class MailService {

	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private MailProperties mailProperties;
	
	public void mailWithAttachment(String to,String body,String subject,String filePath) throws MessagingException {
		MimeMessage message=mailSender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(message,true);
		
	helper.setSubject(subject);
	
	String fromAdd=mailProperties.getUsername();
	if(fromAdd==null || fromAdd.isEmpty()) {
		fromAdd="your default email@makkenaharshini@gmail.com";
	}
	System.out.println(fromAdd);
	helper.setFrom(mailProperties.getUsername());
	helper.setText(body);
	helper.setTo(to);
	
	System.out.println(mailProperties.getUsername());
	try {
        File file = new File(filePath);
        if (!file.exists() || !file.canRead()) {
            throw new AccessDeniedException("File not found or cannot be read: " + filePath);
        }
        FileSystemResource fileResource = new FileSystemResource(file);
        helper.addAttachment(fileResource.getFilename(), fileResource);

        mailSender.send(message);
        System.out.println("Mail sent successfully");
    } catch (AccessDeniedException e) {
        System.err.println("AccessDeniedException: " + e.getMessage());
        // Handle the exception as per your application's requirement
    } catch (Exception e) {
        System.err.println("Exception: " + e.getMessage());
        // Handle other exceptions as needed
    }
}
}