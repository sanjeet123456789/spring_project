package com.pal.sanjeet.springbootmysql.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="comment")
public class Comment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	private String name;
	private String email;
	private String commentdate;
	private String comment_header;
	private String comment_body;
	
	
	public Comment() {
	}
	public Comment(int id, String name, String email, String commentdate, String comment_header, String comment_body) {

		this.id = id;
		this.name = name;
		this.email = email;
		this.commentdate = commentdate;
		this.comment_header = comment_header;
		this.comment_body = comment_body;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCommentdate() {
		return commentdate;
	}
	public void setCommentdate(String commentdate) {
		this.commentdate = commentdate;
	}
	public String getComment_header() {
		return comment_header;
	}
	public void setComment_header(String comment_header) {
		this.comment_header = comment_header;
	}
	public String getComment_body() {
		return comment_body;
	}
	public void setComment_body(String comment_body) {
		this.comment_body = comment_body;
	}
	

}
