package com.tasky.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Board {

	@Id
	@GeneratedValue(generator="boardSequence") 
	@SequenceGenerator(name="boardSequence",sequenceName="board_sequence_db", allocationSize=1)
	private int id;
	
	private String name;
	
	private Boolean privateBoard;
	
	@JsonManagedReference
	@OneToMany(mappedBy="board", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<TaskList> taskLists;
	
	public Board() {}

	public Board(int id, String name, Boolean privateBoard, List<TaskList> taskLists) {
		super();
		this.id = id;
		this.name = name;
		this.privateBoard = privateBoard;
		this.taskLists = taskLists;
	}
	
	public List<TaskList> getTaskLists() {
		return taskLists;
	}

	public void setTaskLists(List<TaskList> taskLists) {
		this.taskLists = taskLists;
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

	public Boolean getPrivateBoard() {
		return privateBoard;
	}

	public void setPrivateBoard(Boolean privateBoard) {
		this.privateBoard = privateBoard;
	}

	@Override
	public String toString() {
		return "Board [id=" + id + ", name=" + name + ", private=" + privateBoard + "]";
	}
	
}
