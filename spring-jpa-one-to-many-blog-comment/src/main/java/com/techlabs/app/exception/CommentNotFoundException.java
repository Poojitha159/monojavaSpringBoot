package com.techlabs.app.exception;

public class CommentNotFoundException extends RuntimeException{
	public CommentNotFoundException(String msg) {
		super(msg);
	}

}
