package com.entities;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Note {
	@Id
	private int id;
	private String title;
	private String content;
	private Date addeddate;
	public Note (int id ,String title, String content, Date addeddate) {
		super();
		this.id =id;
		this.title = title;
		this.content = content;
		this.addeddate = addeddate;
	}
	public int getId() {
		return id;
	}
	public void setId(int noteId) {
		this.id = noteId;
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
	public Date getAddeddate() {
		return addeddate;
	}
	public void setAddeddate(Date addeddate) {
		this.addeddate = addeddate;
	}
	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
