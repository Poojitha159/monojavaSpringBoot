package com.techlabs.app.entity;



import lombok.Builder;
import lombok.Data;


import javax.persistence.*;

@Data

@Builder
@Entity
@Table(name = "ImageData")
public class ImageData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;

    @Lob
    @Column(name = "imagedata")
    private byte[] imageData;

	public static Object builder() {
		
		return null;
	}

	public byte[] getImageData() {
		
		return getImageData();
	}

	public ImageData(Long id, String name, String type, byte[] imageData) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.imageData = imageData;
	}

	public ImageData() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}
	
	
	
}