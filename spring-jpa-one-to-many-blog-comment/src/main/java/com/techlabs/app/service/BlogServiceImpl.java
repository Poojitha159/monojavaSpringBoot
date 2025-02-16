package com.techlabs.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.techlabs.app.dto.BlogDTO;
import com.techlabs.app.entity.Blog;
import com.techlabs.app.entity.Comment;
import com.techlabs.app.exception.ResourceNotFoundException;
import com.techlabs.app.repository.BlogRepository;
import com.techlabs.app.repository.CommentRepository;

@Service
public class BlogServiceImpl implements BlogService{
	
	
	

		 
	private BlogRepository blogRepository;
	
	private CommentRepository commentRepository;

	private CommentService commentService;

	public BlogServiceImpl(BlogRepository blogRepository, CommentRepository commentRepository,CommentService commentService) {
		super();
		this.blogRepository = blogRepository;
		this.commentRepository = commentRepository;
		this.commentService=commentService;
	}

	@Override
    public List<BlogDTO> getAllBlogs() {
		 List<Blog> lst=blogRepository.findAll();
		 List<BlogDTO> blogDtolst=new ArrayList<>();
		 for(Blog b:lst) {
			 blogDtolst.add(convertToDTO(b));
		 }
		 System.out.println(lst);
		 return blogDtolst;
       /* return lst
        		.stream()
        		.map(this::convertToDTO)
        		.collect(Collectors.toList());*/
    }

    @Override
    public BlogDTO getBlogById(int id) {
        Blog blog = blogRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Blog not found with id " + id));
        return convertToDTO(blog);
    }

    @Override
    public BlogDTO createBlog(BlogDTO blogDTO) {
        Blog blog = convertToEntity(blogDTO);
        Blog savedBlog = blogRepository.save(blog);
        return convertToDTO(savedBlog);
    }

    @Override
    public BlogDTO updateBlog(int id, BlogDTO blogDTO) {
        Blog existingBlog = blogRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Blog not found with id " + id));
        existingBlog.setTitle(blogDTO.getTitle());
        existingBlog.setCategory(blogDTO.getCategory());
        existingBlog.setData(blogDTO.getData());
        existingBlog.setPublishedDate(blogDTO.getPublishedDate());
        existingBlog.setPublished(blogDTO.isPublished());
        
         Blog updatedBlog = blogRepository.save(existingBlog);
        return convertToDTO(updatedBlog);
    }

    @Override
    public BlogDTO deleteBlog(int id) {
        Optional<Blog> blogOptional = blogRepository.findById(id);
        if (blogOptional.isPresent()) {
            blogRepository.delete(blogOptional.get());
        } else {
            throw new ResourceNotFoundException("Blog not found with id " + id);
        }
		return null;
    }


    private BlogDTO convertToDTO(Blog blog) {
        BlogDTO blogDTO = new BlogDTO();
        blogDTO.setId(blog.getId());
        blogDTO.setTitle(blog.getTitle());
        blogDTO.setCategory(blog.getCategory());
        blogDTO.setData(blog.getData());
        blogDTO.setPublishedDate(blog.getPublishedDate());
        blogDTO.setPublished(blog.isPublished());
        if(blog.getComments()!=null) {
        	blogDTO.setComments(blog.getComments().stream()
               		.map(commentService::commentToDTO)
               		.toList());    		
        }
        return blogDTO;
    }

    private Blog convertToEntity(BlogDTO blogDTO) {
        Blog blog = new Blog();
       
        blog.setId(blogDTO.getId());
        blog.setTitle(blogDTO.getTitle());
        blog.setCategory(blogDTO.getCategory());
        blog.setData(blogDTO.getData());
        blog.setPublishedDate(blogDTO.getPublishedDate());
        blog.setPublished(blogDTO.isPublished());
        return blog;
    }

	@Override
	public BlogDTO assignCommentToABlog(int cId, int bId) {
		Comment comment=commentRepository.findById(cId)
				.orElseThrow();
		Blog blog=blogRepository.findById(bId)
				.orElseThrow();
 comment.setBlog(blog);
 commentRepository.save(comment);
		return convertToDTO(blog);
	}

	@Override
	public BlogDTO removeCommentToABlog(int cId, int bId) throws NotFoundException {
		Optional<Blog> byId = blogRepository.findById(bId);
		if (byId.isEmpty())
			throw new NotFoundException();

		Optional<Comment> byId2 = commentRepository.findById(cId);
		if (byId2.isEmpty())
			throw new NotFoundException();
		Blog blog = byId.get();
		Comment comment = byId2.get();
		
		comment.setBlog(null);
		commentRepository.save(comment);
		
		blog.getComments().remove(comment);
		blogRepository.save(blog);

		BlogDTO fromBlogToBlogDto = convertToDTO(blog);

		return fromBlogToBlogDto;
	}

	}

