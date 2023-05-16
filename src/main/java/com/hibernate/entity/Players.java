package com.hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name="CricketPlayers")
public class Players {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String skills;
	public Players() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Players(String name, String skills) {
		super();
		this.name = name;
		this.skills = skills;
	}
	public Players(int id, String name, String skills) {
		super();
		this.id = id;
		this.name = name;
		this.skills = skills;
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
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	@Override
	public String toString() {
		return "Players [id=" + id + ", name=" + name + ", skills=" + skills + "]";
	}

}
