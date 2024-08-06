package com.techlabs.demo.model;

import org.springframework.stereotype.Component;

@Component

public class VideoResource implements Resource {

	@Override
	public String getResourceMaterial() {
		
		return "Play video";
	}

}
