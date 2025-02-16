package com.techlabs.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.techlabs.app.dto.CommentDTO;

import com.techlabs.app.entity.Comment;
import com.techlabs.app.exception.CommentNotFoundException;
import com.techlabs.app.exception.ResourceNotFoundException;
import com.techlabs.app.repository.BlogRepository;
import com.techlabs.app.repository.CommentRepository;

@Service

public class CommentServiceImpl implements CommentService{
	
	private CommentRepository commentRepository;

private BlogRepository blogRepository;
	
	
	public CommentServiceImpl(CommentRepository commentRepository) {
		super();
		this.commentRepository = commentRepository;
	}

	@Override
	public List<CommentDTO> getAllComments() throws NotFoundException {
		/*return commentRepository.findAll()
        		.stream()
        		.map(this::convertToDTO)
        		.collect(Collectors.toList());
		*/
		List<Comment> all = commentRepository.findAll();

		List<CommentDTO> comments = getList(all);

		return comments;
	}

	@Override
	public CommentDTO getCommentById(int id) {
		Comment comment=commentRepository.findById(id)
		.orElseThrow(() -> new CommentNotFoundException("Comment not found with id " + id));
        return convertToDTO(comment);
		
	}

	@Override
    public CommentDTO addComment(CommentDTO commentDTO) {
        Comment comment = new Comment();
        System.out.println(commentDTO.getDescription());
        comment.setDescription(commentDTO.getDescription());
        Comment savedComment = commentRepository.save(comment);
        return convertToDTO(savedComment);
    }
	@Override
    public CommentDTO updateComment(int id, CommentDTO commentDTO) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new CommentNotFoundException("Comment not found with id: " + id));
        comment.setDescription(commentDTO.getDescription());
        Comment updatedComment = commentRepository.save(comment);
        return convertToDTO(updatedComment);
    }
	@Override
    public void deleteComment(int id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new CommentNotFoundException("Comment not found with id: " + id));
        commentRepository.delete(comment);
    }


	private CommentDTO convertToDTO(Comment comment ) {
		CommentDTO commentDTO = new CommentDTO();
       
		commentDTO.setId(comment.getId());
		commentDTO.setDescription(comment.getDescription());
		
        
       return commentDTO;
    }

	@Override
	public List<CommentDTO> getCommentByBlogId(int id) throws NotFoundException {
		List<Comment> all = commentRepository.findCommentByBlog_id(id);
		return getList(all);
	}
	private List<CommentDTO> getList(List<Comment> all) throws NotFoundException {
		if (all == null || all.size() == 0)
			throw new NotFoundException();
		List<CommentDTO> comments = new ArrayList<>();
		for (Comment c : all) {
			comments.add(convertToDTO(c));
		}
		return comments;
	}

	@Override
	public CommentDTO commentToDTO(Comment comment) {
		
		CommentDTO commentDTO=new CommentDTO();
		commentDTO.setId(comment.getId());
		commentDTO.setDescription(comment.getDescription());
		return commentDTO;
	}


    
}
