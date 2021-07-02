package com.tasky.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Task {

	@Id
	@GeneratedValue(generator="taskSequence") 
	@SequenceGenerator(name="taskSequence",sequenceName="task_sequence_db", allocationSize=1)
	private int id;
	
	private String name;
	
	private String description;
	
	@JsonManagedReference
	@OneToMany(mappedBy="task", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Comment> comments;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="tasklist_fk")
	public TaskList taskList;

	public Task() {}

	public Task(int id, String name, String description, TaskList taskList) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.taskList = taskList;
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
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public TaskList getTaskList() {
		return taskList;
	}

	public void setTaskList(TaskList taskList) {
		this.taskList = taskList;
	}
	
	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
}
