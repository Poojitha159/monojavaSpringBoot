package com.techlabs.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techlabs.app.dto.BlogDTO;
import com.techlabs.app.entity.Blog;
@Repository
public interface BlogRepository extends JpaRepository<Blog,Integer>{

	List<Blog> findAll();

	Optional<Blog> findById(int id);

	BlogDTO save(BlogDTO blogDTO);

	void delete(Blog existingBlog);

	Blog save(Blog blog);

}
