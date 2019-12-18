package com.soict.service_impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soict.entities.KeDon;
import com.soict.repository.KeDonRepository;
import com.soict.service.KeDonService;

@Service
public class KeDonService_impl implements KeDonService {

	@Autowired
	private KeDonRepository kedonRepository;
	@Override
	public boolean save(KeDon keDon) {
		
		try {
			this.kedonRepository.save(keDon);
			return true;
		} catch (Exception e) {
			showError("save", e);
		}
		return false;
	}

	@Override
	public boolean delete(KeDon keDon) {
		try {
			this.kedonRepository.delete(keDon);
			return true;
		} catch (Exception e) {
			showError("delete", e);
			
		}
		return false;
	}

	@Override
	public List<KeDon> findAll() {
		try {
			return this.kedonRepository.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			showError("findAll() ", e);
		}
		
		return null;
	}

	@Override
	public KeDon findByIdDon(String don) {
		try {
			return this.kedonRepository.findByIdDon(don);
		} catch (Exception e) {
			// TODO: handle exception
			showError("findByIdDon()  ", e);
		}
		return null;
	}

	@Override
	public KeDon findByIdBenh(String benh) {
		// TODO Auto-generated method stub
		try {
			return this.kedonRepository.findByIdBenh(benh);
		} catch (Exception e) {
			showError("findByIdBenh() ", e);
			// TODO: handle exception
		}
		return null;
	}
	
	public void showError(String s,Exception e) {
		System.out.println("error "+ s+" in KeDonService_impl: "+e.getMessage());
	}

}
