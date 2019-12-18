package com.soict.service_impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.soict.entities.BenhNhan;
import com.soict.repository.BenhNhanRepository;
import com.soict.service.BenhNhanService;

import net.bytebuddy.asm.Advice.Return;
import net.bytebuddy.asm.Advice.This;
@Service
public class BenhNhanService_impl implements BenhNhanService{
	private static int id=11;
	
	@Autowired
	private BenhNhanRepository benhNhanRepository;
	
	@Override
	public List<BenhNhan> findAll() {
		// TODO Auto-generated method stub
		try {
			return this.benhNhanRepository.findAll();
		} catch (Exception e) {
			
			e.getMessage();
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public BenhNhan findById(String id) {
		try {
			return this.benhNhanRepository.findByIdBN(id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("không có bệnh nhân nào ở findById");
		}
		
		return null;
	}

	@Override
	public List<BenhNhan> findByName(String name) {
		try {
			return this.benhNhanRepository.findByTenBN(name);
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		
		return null;
	}

	@Override
	public BenhNhan findByCmnd(String cmnd) {
		// TODO Auto-generated method stub
		try {
			return this.benhNhanRepository.findByCmnd(cmnd);
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		
		return null;
	}

	@Override
	public boolean save(BenhNhan benhNhan) {
		try {
			BenhNhan benhNhan2=this.findById(benhNhan.getIdBN());
			if(benhNhan2==null) {
				System.out.println("đã vòa save");
				benhNhan.setIdBN("BN-"+id);
				id++;
				this.benhNhanRepository.save(benhNhan);
				return true;
			}
			else{
				benhNhan2.setTinnhan(benhNhan.getTinnhan());
				this.benhNhanRepository.save(benhNhan2);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
			e.getMessage();
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean delete(BenhNhan benhNhan) {
		// TODO Auto-generated method stub
		
		try {
			this.benhNhanRepository.delete(benhNhan);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	
}
