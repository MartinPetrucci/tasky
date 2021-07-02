package com.tasky.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Comment {
	
	@Id
	@GeneratedValue(generator="commentSequence") 
	@SequenceGenerator(name="commentSequence",sequenceName="comment_sequence_db", allocationSize=1)
	private int id;
	
	private String content;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="task_fk")
	public Task task;

	public Comment() {}

	public Comment(int id, String content, Task task) {
		super();
		this.id = id;
		this.content = content;
		this.task = task;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", content=" + content + "]";
	}
	
}
