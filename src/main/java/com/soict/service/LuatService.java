package com.soict.service;

import java.util.List;

import com.soict.entities.Luat;

public interface LuatService {
	List<Luat> findAll();
	
	List<Luat> findByIdTC(String idTC);
	
	List<Luat> findByIdBenh(String idBenh);
	
	boolean delete(Luat luat);
	
	boolean save(Luat luat);
	
	Luat findByTC_B(String trieuChung,String benh);
	List<Luat> searchNhieu(String idTC,String idBenh);

}
