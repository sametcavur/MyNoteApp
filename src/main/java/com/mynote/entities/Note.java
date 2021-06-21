package com.mynote.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Note {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long userId;
	private String title;
	@Column(length = 9999)
	private String content;
	private Date createDate = new Date();
	public Note() {
	}
	public Note(long userId, String title, String content) {
		this.userId = userId;
		this.title = title;
		this.content = content;
	}
	public Long getId() {
		return id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateDate() {
		return createDate;
	}

	@Override
	public String toString() {
		return "Note [id=" + id + ", userId=" + userId + ", title=" + title + ", content=" + content + ", createDate="
				+ createDate + "]";
	}
}
