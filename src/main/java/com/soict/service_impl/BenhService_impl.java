package com.soict.service_impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soict.entities.Benh;
import com.soict.repository.BenhRepository;
import com.soict.service.BenhService;

@Service
public class BenhService_impl implements BenhService {
	
	@Autowired
	private BenhRepository benhRepository;
	@Override
	public List<Benh> findAll() {
		
		try {
			System.out.println("ok");
			return this.benhRepository.findAll();
			
		} catch (Exception e) {
			showerror("findAll() ", e);
		}
		return null;
	}

	


	@Override
	public boolean save(Benh benh) {
		try {
			this.benhRepository.save(benh);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			showerror("save", e);
		}
		
		return false;
	}

	@Override
	public boolean delete(Benh benh) {
		try {
			this.benhRepository.delete(benh);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			showerror("delete ", e);
		}
		
		return false;
	}
	
	public void showerror(String s,Exception e) {
		System.out.println(" Error "+  s+" in BenhService_impl : ");
		e.getMessage();
	}

	@Override
	public Benh findByTenBenh(String ten) {
		try {
			return this.benhRepository.findByTenBenh(ten);
		} catch (Exception e) {
			// TODO: handle exception
			showerror("findBytenBenh() ", e);
		}
		return null;
	}




	@Override
	public Benh findByIdBenh(String id) {
		try {
			return this.benhRepository.findByIdBenh(id);
		} catch (Exception e) {
			// TODO: handle exception
			
			showerror("findByIdBenh() ", e);
		}
		return null;
	}

}
