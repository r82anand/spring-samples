package com.sivadas.anand.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FRUIT_TABLE")
public class Fruit {
	
	@Id
	@Column(name = "FRUIT_ID")
	private Integer id;

	@Column(name = "FRUIT_NAME")
	private String name;

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

	@Override
	public String toString() {
		return "Fruit [id=" + id + ", name=" + name + "]";
	}
	
}
