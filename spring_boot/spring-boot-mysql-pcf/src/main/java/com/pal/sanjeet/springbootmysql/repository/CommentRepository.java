package com.pal.sanjeet.springbootmysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pal.sanjeet.springbootmysql.model.Comment;

public interface CommentRepository extends JpaRepository<Comment,Integer>{

}
