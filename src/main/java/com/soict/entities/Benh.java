package com.soict.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "benh")
public class Benh {
	@Id
	@Column(name = "idbenh")
	private String idBenh;
	
	@Column(name = "tenbenh")
	private String tenBenh;
	public String getIdBenh() {
		return idBenh;
	}
	public String getTenBenh() {
		return tenBenh;
	}
	public void setIdBenh(String idBenh) {
		this.idBenh = idBenh;
	}
	public void setTenBenh(String tenBenh) {
		this.tenBenh = tenBenh;
	}
}
