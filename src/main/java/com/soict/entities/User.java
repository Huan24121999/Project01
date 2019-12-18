package com.soict.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	@Id
	@Column(name = "username" , length = 20, nullable = false)
	private String username;
	@Column(name = "password" , length = 20, nullable = false)
	private String password;
	@Column(name="active")
	private int active;
	//1 là admin, 2 là user, 3 là khách, 4 là xóa tài khoản
	
	public User() {
		this.active=2;
	}
	public String getPassword() {
		return password;
	}
	public String getUsername() {
		return username;
	}
	public int getActive() {
		return this.active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setUsername(String username) {
		this.username = username;
	}

}
