package com.soict.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trieuchung")
public class TrieuChung {
	@Id
	@Column(name = "idTC",length = 5,nullable = false)
	private String  idTC;
	@Column(name = "tenTC",length = 5,nullable = false)
	private String tenTC;
	public void setIdTC(String idTC) {
		this.idTC = idTC;
	}
	public void setTenTC(String tenTC) {
		this.tenTC = tenTC;
	}
	public String getIdTC() {
		return idTC;
	}
	public String getTenTC() {
		return tenTC;
	}

}
