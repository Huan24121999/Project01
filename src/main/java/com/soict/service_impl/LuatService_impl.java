package com.soict.service_impl;

import java.util.List;

import javax.sound.midi.Soundbank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soict.entities.Luat;
import com.soict.repository.LuatRepository;
import com.soict.service.LuatService;

import javassist.bytecode.Descriptor.Iterator;

@Service
public class LuatService_impl  implements LuatService{
	@Autowired
	private LuatRepository luatRepository;
	@Override
	public List<Luat> findAll() {
		
		try {
			return this.luatRepository.findAll();
		} catch (Exception e) {
			showError("findAll()", e);
		}
		return null;
	}

	@Override
	public List<Luat> findByIdTC(String idTC) {
		try {
			return this.luatRepository.findByIdTC(idTC);
		} catch (Exception e) {
			// TODO: handle exception
			showError("findByIdTC", e);
		}
		return null;
	}

	@Override
	public List<Luat> findByIdBenh(String idBenh) {
		try {
			return this.luatRepository.findByIdBenh(idBenh);
		} catch (Exception e) {
			// TODO: handle exception
			showError("findByIdBenh() ", e);
		}
		return null;
	}

	@Override
	public boolean delete(Luat luat) {
		// TODO Auto-generated method stub
		try {
			this.luatRepository.delete(luat);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			showError("delete ", e);
		}
		return false;
	}

	@Override
	public boolean save(Luat luat) {
		
		try {
			this.luatRepository.save(luat);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			showError("save", e);
		}
		return false;
	}
	
	public void showError(String s1, Exception e) {
		System.out.println("Error "+s1+" in LuatService_impl: ");
		e.getMessage();
	}
	
	public void themLuat(List<Luat> luats) {
		for (Luat luat : luats) {
			List<Luat> listLuats=findByIdTC(luat.getIdTC());
			for (Luat luat2 : listLuats) {
				if(luat2.getIdBenh()==luat.getIdBenh())
					break;
				
				else {
					save(luat);
				}
			}
		}
			
	}

	@Override
	public Luat findByTC_B(String trieuChung, String benh) {
		// TODO Auto-generated method stub
		System.out.println("cần tìm triệu chứng và benh là: "+trieuChung+"   "+benh);
		List<Luat> luats=this.findByIdTC(trieuChung);
		System.out.println("luat size: " +luats.size());
		for (Luat luat : luats) {
			System.out.println("dữ liệu này "+luat.getIdTC()+" "+luat.getIdBenh()+" "+luat.getKd());
		}
		for (Luat luat : luats) {
			System.out.println("với bộ dữ liệu tìm được: "+luat.getIdTC()+" "+luat.getIdBenh());
			if(luat.getIdBenh()==benh)
				return luat;
		}
		System.out.println("không tìm được triệu chwungs bệnh nên NULL");
		return null;
		
	}

	@Override
	public List<Luat> searchNhieu(String s1, String s2) {
		// TODO Auto-generated method stub
		try {
			return this.luatRepository.search(s1, s2);
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("LỖI LẮM RÒI ĐÓ NHA ");
			e.getMessage();
			e.printStackTrace();
		}
		
		return null;
	}
}
