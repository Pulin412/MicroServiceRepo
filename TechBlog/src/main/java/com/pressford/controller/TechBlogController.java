package com.pressford.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pressford.entity.Post;
import com.pressford.security.CustomUserDetails;
import com.pressford.service.TechBlogService;
import com.pressford.service.UserService;

@RestController
public class TechBlogController {

	@Autowired
	private TechBlogService techBlogService;
	
    @Autowired
    private UserService userService;
	
	@GetMapping(value = "/posts")
	public List<Post> posts(){
		return techBlogService.getAllPosts();
	}
	
	@PostMapping(value = "/post")
	public String publishPosts(@RequestBody Post post) {
		
		CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(post.getDateCreated() == null)
			post.setDateCreated(new Date());
		post.setCreator(userService.getUser(userDetails.getUsername()));
		techBlogService.insert(post);
		
		return "Message successfully published"; 
	}
	
	@GetMapping(value="/posts/{username}")
	public List<Post> postsByUsername(@PathVariable String username){
		return techBlogService.findByUser(userService.getUser(username));
	}
}
