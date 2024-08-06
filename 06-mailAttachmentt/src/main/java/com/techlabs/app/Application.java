package com.techlabs.app;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.techlabs.app.service.MailService;

import jakarta.mail.MessagingException;

@SpringBootApplication
public class Application {
	@Autowired
	private MailService mailService;
	

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException,IOException{
		mailService.mailWithAttachment("20jr1a0582@gmail.com", "Thisismailbody","Demo mail with attachment","C:\\Users\\ChHarshini\\Pictures\\Documents Required for Home Loan by Kotak Bank.jpg");
		
	}
}
