package com.sivadas.anand.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "USERS")
public class User {

	@Id
	@Column(name = "ID")
	private Long id;
	@Column(name = "FNAME", nullable = false)
	private String fName;
	@Column(name = "LNAME", nullable = false)
	private String lName;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(final String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(final String lName) {
		this.lName = lName;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", fName=" + fName + ", lName=" + lName + "]";
	}

}
