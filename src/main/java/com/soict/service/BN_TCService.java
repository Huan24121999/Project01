package com.soict.service;

import java.util.ArrayList;
import java.util.List;

import com.soict.entities.BN_TC;
//import com.soict.entities.Luat;
import com.soict.entities.BoSo;

public interface BN_TCService {
	
    List<BN_TC> findAll();
	
	List<BN_TC> findByIdTC(String idTC);
	
	List<BN_TC> findByIdBN(String idBN);
	
	boolean delete(BN_TC bn_TC);
	
	boolean save(BN_TC bn_TC);
	public float xuly(ArrayList<BoSo> listBNTC,ArrayList<BoSo> listTCB);
	
}
