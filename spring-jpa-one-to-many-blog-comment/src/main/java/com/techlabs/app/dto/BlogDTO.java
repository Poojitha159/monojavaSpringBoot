package com.techlabs.app.dto;
/*
import java.time.LocalDateTime;
import java.util.List;

import com.techlabs.app.entity.Comment;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data

public class BlogDTO {

	  private int id;
	  @NotBlank(message="Title is mandatory")
	  @Size(min=2,max=250,message="Title sholud be between 2 and250 characters")
	    private String title;
	    private String category;
	    private String data;
	    private LocalDateTime publishedDate;
	    private boolean published;
	    
		@OneToMany(mappedBy="blog", cascade=CascadeType.ALL,orphanRemoval=true)

	    private List<CommentDTO> comments;
		
		
		public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getTitle() {
	        return title;
	    }

	    public void setTitle(String title) {
	        this.title = title;
	    }

	    public String getCategory() {
	        return category;
	    }

	    public void setCategory(String category) {
	        this.category = category;
	    }

	    public String getData() {
	        return data;
	    }

	    public void setData(String data) {
	        this.data = data;
	    }

	    public LocalDateTime getPublishedDate() {
	        return publishedDate;
	    }

	    public void setPublishedDate(LocalDateTime publishedDate) {
	        this.publishedDate = publishedDate;
	    }

	    public boolean isPublished() {
	        return published;
	    }

	    public void setPublished(boolean published) {
	        this.published = published;
	    }

	   /* public List<Comment> getComments() {
	        return comments;
	    }

	   public void setComments(List<Comment> comments) {
	        this.comments = comments;
	    }

	    public void addComment(Comment comment) {
	        this.comments.add(comment);
	        comment.setBlog(this);
	    }

}*/

import java.time.LocalDateTime;
import java.util.List;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BlogDTO {

    private int id;

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Category is required")
    private String category;

    @NotBlank(message = "Data is required")
    private String data;

    @NotNull(message = "Published Date is required")
    private LocalDateTime publishedDate;

    @NotNull(message = "Published status is required")
    private boolean published;

    private List<CommentDTO> comments;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public LocalDateTime getPublishedDate() {
    return publishedDate;
  }

  public void setPublishedDate(LocalDateTime publishedDate) {
    this.publishedDate = publishedDate;
  }

  public boolean isPublished() {
    return published;
  }

  public void setPublished(boolean published) {
    this.published = published;
  }

  public List<CommentDTO> getComments() {
    return comments;
  }

  public void setComments(List<CommentDTO> comments) {
    this.comments = comments;
  }

   
}

