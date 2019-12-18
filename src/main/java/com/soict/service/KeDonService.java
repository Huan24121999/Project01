package com.soict.service;

import java.util.List;

import com.soict.entities.KeDon;

public interface KeDonService {
	
	boolean save(KeDon keDon);
	
	boolean delete(KeDon keDon);
	
	List<KeDon> findAll();
	
	KeDon findByIdDon(String don);
	
	KeDon findByIdBenh(String benh);
	
	
	

}
