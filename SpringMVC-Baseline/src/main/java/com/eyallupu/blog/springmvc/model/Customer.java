package com.eyallupu.blog.springmvc.model;

import java.io.Serializable;
import java.sql.Date;

public class Customer implements Serializable{

	/**
	 * SUID
	 */
	private static final long serialVersionUID = 3599396752230789827L;

	private String firstName;

	private String lastName;

	private Date birhtdate;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirhtdate() {
		return birhtdate;
	}

	public void setBirhtdate(Date birhtdate) {
		this.birhtdate = birhtdate;
	}

}
