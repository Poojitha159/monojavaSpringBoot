package com.techlabs.app.service;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;

import com.techlabs.app.dto.CommentDTO;
import com.techlabs.app.entity.Comment;

public interface CommentService {

	List<CommentDTO> getAllComments() throws NotFoundException;

	CommentDTO getCommentById(int id);

	
	CommentDTO updateComment(int id, CommentDTO commentDTO);

	void deleteComment(int id);

	CommentDTO addComment(CommentDTO commentDTO);

	List<CommentDTO> getCommentByBlogId(int id) throws NotFoundException;

	public CommentDTO commentToDTO(Comment comment);

	//CommentDTO addComment(CommentDTO commentDTO);
	

}
