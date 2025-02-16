package com.techlabs.app.service;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.techlabs.app.dto.BlogDTO;
import com.techlabs.app.entity.Blog;

public interface BlogService {

	List<BlogDTO> getAllBlogs();

	BlogDTO getBlogById(int id);

	BlogDTO createBlog(BlogDTO blogDTO);

	BlogDTO updateBlog(int id, BlogDTO blogDTO);

	BlogDTO deleteBlog(int id);

	BlogDTO assignCommentToABlog(int cId, int bId);

	BlogDTO removeCommentToABlog(int cId, int bId) throws NotFoundException;
	
	

}
