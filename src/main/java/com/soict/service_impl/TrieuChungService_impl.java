package com.soict.service_impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soict.entities.TrieuChung;
import com.soict.repository.TrieuChungRepository;
import com.soict.service.TrieuChungService;

@Service
public class TrieuChungService_impl implements TrieuChungService {
	@Autowired
	private TrieuChungRepository trieuChungRepository;
	@Override
	public List<TrieuChung> findAll() {
		try {
			return this.trieuChungRepository.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			showError("findAll() ", e);
		}
		return null;
	}

	@Override
	public TrieuChung findBytenTC(String tenTC) {
		try {
			return this.trieuChungRepository.findByTenTC(tenTC);
		} catch (Exception e) {
			// TODO: handle exception
			showError("findByTenTc() ", e);
		}
		return null;
	}

	@Override
	public TrieuChung findByIdTC(String idTC) {
		try {
			return this.trieuChungRepository.findByIdTC(idTC);
		} catch (Exception e) {
			showError("findById() ", e);
		}
		return null;
	}

	@Override
	public boolean save(TrieuChung trieuChung) {
		try {
			this.trieuChungRepository.save(trieuChung);
			return true;
		} catch (Exception e) {
			showError("save() ", e);
		}
		return false;
	}

	@Override
	public boolean delete(TrieuChung trieuChung) {
		try {
			this.trieuChungRepository.delete(trieuChung);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			showError("delete() ", e);
		}
		return false;
	}
	
	public void showError(String s1, Exception e) {
		System.out.println("Error "+s1+" in TrieuChungService_impl: "+e.getMessage());
	}
	
	

}
