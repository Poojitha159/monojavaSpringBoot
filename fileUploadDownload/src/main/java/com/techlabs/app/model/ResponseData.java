package com.techlabs.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseData {

    public ResponseData(String fileName2, String downloadURl2, String contentType, long size) {
		this.fileName=fileName2;
		this.downloadURL=downloadURl2;
		this.fileType=contentType;
		this.fileSize=size;
	}
	private String fileName;
    private String downloadURL;
    private String fileType;
    private long fileSize;
    
    
}
