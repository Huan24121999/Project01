package com.soict.service;

import java.util.List;

import com.soict.entities.TrieuChung;

public interface TrieuChungService {
	
	List<TrieuChung> findAll();
	
	TrieuChung findBytenTC(String tenTC);
	
	TrieuChung findByIdTC(String idTC);
	
	boolean save(TrieuChung trieuChung);
	
	boolean delete(TrieuChung trieuChung);
	

}
