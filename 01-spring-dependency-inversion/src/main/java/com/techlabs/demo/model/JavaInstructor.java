package com.techlabs.demo.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

//@Component
public class JavaInstructor implements Instructor {

	private Resource resource;

	public JavaInstructor(@Qualifier("pdfResource") Resource resource) {
		super();
		this.resource = resource;
	}

	public JavaInstructor() {
		System.out.println("JAVAjava");
	}

	@Override
	public String getTrainingPlan() {

		return "Practice OOP's concepts";
	}

	@Override
	public String getResource() {

		return this.resource.getResourceMaterial();
		
	}

}
