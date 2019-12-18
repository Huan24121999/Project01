package com.soict.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "luat")
public class Luat implements Serializable {
	@Id
	@Column(name = "idTC")
	private String idTC;
	
	
	@Column(name ="idbenh")
	private String idBenh;
	
	@Column(name="kd")
	private float kd;
	
	@Column(name="tb")
	private float tb;
	
	@Column(name="pd")
	private float pd;
	
	public String getIdBenh() {
		return idBenh;
	}
	public String getIdTC() {
		return idTC;
	}
	public void setIdBenh(String idBenh) {
		this.idBenh = idBenh;
	}
	public void setIdTC(String idTC) {
		this.idTC = idTC;
	}
	public float getKd() {
		return kd;
	}
	public float getPd() {
		return pd;
	}
	public float getTb() {
		return tb;
	}
	public void setKd(float kd) {
		this.kd = kd;
	}
	public void setPd(float pd) {
		this.pd = pd;
	}
	public void setTb(float tb) {
		this.tb = tb;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
