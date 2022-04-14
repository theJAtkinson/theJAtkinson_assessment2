package com.qa.hss.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hero {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private Integer powerLevel;
	
	@Column(nullable = false)
	private String powers;
	
	@Column(nullable = false)
	private String tragicBackstory;

	public Hero(Integer id, String name, Integer powerLevel, String powers, String tragicBackstory) {
		super();
		this.id = id;
		this.name = name;
		this.powerLevel = powerLevel;
		this.powers = powers;
		this.tragicBackstory = tragicBackstory;
	}

	public Hero() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPowerLevel() {
		return powerLevel;
	}

	public void setPowerLevel(Integer powerLevel) {
		this.powerLevel = powerLevel;
	}

	public String getPowers() {
		return powers;
	}

	public void setPowers(String powers) {
		this.powers = powers;
	}

	public String getTragicBackstory() {
		return tragicBackstory;
	}

	public void setTragicBackstory(String tragicBackstory) {
		this.tragicBackstory = tragicBackstory;
	}

	@Override
	public String toString() {
		return "Hero [id=" + id + ", name=" + name + ", powerLevel=" + powerLevel + ", powers=" + powers
				+ ", tragicBackstory=" + tragicBackstory + "]";
	}
	
}
