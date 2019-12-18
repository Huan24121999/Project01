package com.soict.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "kedon")
public class KeDon {
	@Id
	@Column(name = "idDon")
	private String idDon ;
	@Column(name="idBenh")
	private String idBenh;
	@Column(name = "ghichu")
	private String ghiChu;
	
	
	public String getGhiChuString() {
		return ghiChu;
	}
	public String getIdBenhString() {
		return idBenh;
	}
	public String getIdDonString() {
		return idDon;
	}
	
	public void setGhiChuString(String ghiChuString) {
		this.ghiChu = ghiChuString;
	}
	public void setIdBenhString(String idBenhString) {
		this.idBenh = idBenhString;
	}
	public void setIdDonString(String idDonString) {
		this.idDon = idDonString;
	}
	
	
}
