package com.pal.sanjeet.springbootmysql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pal.sanjeet.springbootmysql.model.Comment;
import com.pal.sanjeet.springbootmysql.repository.CommentRepository;

@Controller
public class CommentController {
	@Autowired
	private CommentRepository commentRepository;
	
	
	@PostMapping("/submitComment")
	public String addcomment(@ModelAttribute("comment")Comment comment ,Model model) {
		commentRepository.save(comment);
		model.addAttribute("status", "comment:"+comment.getComment_header()+"successfully added");
		return "home";
	}
	
	@GetMapping("/getComment")
	public String getcomment(Model model) {
		model.addAttribute("comment", commentRepository.findAll());
		return "result";
	}

}
