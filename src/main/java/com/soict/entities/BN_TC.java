package com.soict.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bn_tc")
public class BN_TC {
	@Id
	@Column(name = "idBN")
	private String idBN;
	@Column(name = "idTC")
	private String idTC;

	@Column(name="kd")
	private float kd;
	
	@Column(name="tb")
	private float tb;
	
	@Column(name="pd")
	private float pd;
	
	public String getIdBN() {
		return idBN;
	}
	public String getIdTC() {
		return idTC;
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
	public void setIdBN(String idBN) {
		this.idBN = idBN;
	}
	public void setIdTC(String idTC) {
		this.idTC = idTC;
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
	

}
