package com.soict.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "benhnhan")
public class BenhNhan {
	private static int x=11;
	@Id
	@Column(name = "idBN",length = 5,nullable = false)
	private String idBN;
	@Column(name = "tenBN")
	private String tenBN;
	@Column(name = "diachiBN")
	private String diachiBN;
	@Column(name = "sdtBN")
	private String sdtBN;
	@Column(name = "cmndBN")
	private String cmnd;
	@Column(name ="ghichuBN")
	private String ghiChu;
	@Column(name="tinnhan")
	private String tinnhan;
	
	@Column(name = "linkanh")
	private String linkanh;
	public String getLinkanh() {
		return linkanh;
	}
	public void setLinkanh(String linkanh) {
		this.linkanh = linkanh;
	}
	
	
	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}
	public void setDiachiBN(String diachiBN) {
		this.diachiBN = diachiBN;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	
	public void setIdBN(String idBN) {
		this.idBN = idBN;
	}
	
	public void setSdtBN(String sdtBN) {
		this.sdtBN = sdtBN;
	}
	
	public void setTenBN(String tenBN) {
		this.tenBN = tenBN;
	}
	
	public String getCmnd() {
		return cmnd;
	}
	
	public String getDiachiBN() {
		return diachiBN;
	}
	
	public String getGhiChu() {
		return ghiChu;
	}
	
	public String getIdBN() {
		return idBN;
	}
	
	public String getSdtBN() {
		return sdtBN;
	}
	
	public String getTenBN() {
		return tenBN;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	public BenhNhan() {
//		this.idBN="BN-"+x;
//		x++;
	}
	
	public String getTinnhan() {
		return tinnhan;
	}
	public void setTinnhan(String tinnhan) {
		this.tinnhan = tinnhan;
	}
}
