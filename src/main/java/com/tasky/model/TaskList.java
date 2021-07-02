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
public class TaskList {

	@Id
	@GeneratedValue(generator = "taskListSequence")
	@SequenceGenerator(name = "taskListSequence", sequenceName = "tasklist_sequence_db", allocationSize = 1)
	private int id;
	
	private String name;
	
	@JsonManagedReference
	@OneToMany(mappedBy="taskList", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Task> tasks;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="board_fk")
	private Board board;

	public TaskList() {}
	
	public TaskList(int id, String name, List<Task> tasks, Board board) {
		super();
		this.id = id;
		this.name = name;
		this.tasks = tasks;
		this.board = board;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
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

	@Override
	public String toString() {
		return "TaskList [id=" + id + ", name=" + name + "]";
	}
}
