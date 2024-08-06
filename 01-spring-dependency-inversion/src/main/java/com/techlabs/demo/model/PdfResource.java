package com.techlabs.demo.model;

import org.springframework.stereotype.Component;

@Component
public class PdfResource implements Resource {

	@Override
	public String getResourceMaterial() {
		
		return "Play PDF's";
	}

}
