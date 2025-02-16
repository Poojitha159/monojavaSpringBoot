package com.techlabs.app.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="blog")
@Data
@NoArgsConstructor

public class Blog {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable=false)
	private String title;
	private String category;
	@Column(columnDefinition="TEXT")
	@Lob
	private String data;
	private LocalDateTime publishedDate;
	private boolean published;
	
	@OneToMany(mappedBy="blog", cascade=CascadeType.ALL,orphanRemoval=true)
	@JsonManagedReference
	//private List<Comment> comment;
	
	private List<Comment> comments = new ArrayList<>();
	

	

}
