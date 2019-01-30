package com.pressford.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pressford.entity.Post;
import com.pressford.entity.User;
import com.pressford.repository.TechBlogRepository;

@Service
public class TechBlogService {

	@Autowired
	private TechBlogRepository techBlogRepository;

	public List<Post> getAllPosts() {
		return techBlogRepository.findAll();
	}

	public void insert(Post post) {
		techBlogRepository.save(post);
	}

	public List<Post> findByUser(User user) {
		return techBlogRepository.findByCreatorId(user.getId());
	}
}
