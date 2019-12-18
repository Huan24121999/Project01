package com.soict.service;

import java.util.List;

import com.soict.entities.BenhNhan;

public interface BenhNhanService {
	List<BenhNhan> findAll();
	
	BenhNhan findById(String id);
	
	List<BenhNhan> findByName(String name);
	
	BenhNhan findByCmnd(String cmnd);
	
	boolean save(BenhNhan benhNhan);
	
	boolean delete(BenhNhan benhNhan);
}
