package com.soict.service;

import java.util.List;

import com.soict.entities.Benh;

public interface BenhService {
	List<Benh> findAll();
	
	Benh findByIdBenh(String id);
	
	Benh findByTenBenh(String ten);
	
	boolean save(Benh benh);
	
	boolean delete(Benh benh);
}
