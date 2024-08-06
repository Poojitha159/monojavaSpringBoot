package com.techlabs.demo.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Component
public class PythonInstructor implements Instructor {

	
	private Resource resource;
	
	public PythonInstructor(@Qualifier("videoResource") Resource resource) {
		super();
		this.resource = resource;
	}

	public PythonInstructor() {
		System.out.println("python");
	}

	

	@Override
	public String getTrainingPlan() {
		
		return " Practice Python Insrtucor";
	}

	@Override
	public String getResource() {
		
		return this.resource.getResourceMaterial();
		
	}

}
