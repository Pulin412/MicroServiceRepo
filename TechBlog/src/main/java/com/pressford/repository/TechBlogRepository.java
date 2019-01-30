package com.pressford.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pressford.entity.Post;

@Repository
public interface TechBlogRepository extends JpaRepository<Post, Long>{

	List<Post> findByCreatorId(Long id);

	
}
