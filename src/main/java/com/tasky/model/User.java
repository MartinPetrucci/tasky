package com.tasky.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class User {

	@Id
	@GeneratedValue(generator="userSequence") 
	@SequenceGenerator(name="userSequence",sequenceName="user_sequence_db", allocationSize=1)
	private int id;
	
	private String name;
	
	private String email;
	
	private String profilePic;

	public User() {}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", profilePic=" + profilePic + "]";
	}

	public User(int id, String name, String email, String profilePic) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.profilePic = profilePic;
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

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}
}
