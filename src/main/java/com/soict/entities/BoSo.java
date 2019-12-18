package com.soict.entities;

public class BoSo {
	private float kd;
	private float tb;
	private float pd;
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
	
	public BoSo(float kd,float tb, float pd) {
		this.kd=kd;
		this.tb=tb;
		this.pd=pd;
	}
	public BoSo() {
		
	}
	

}
