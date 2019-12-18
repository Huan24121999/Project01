package com.soict.service_impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.standard.expression.Each;

import com.soict.entities.BN_TC;
import com.soict.entities.BoSo;
import com.soict.repository.BN_TCRepository;
import com.soict.service.BN_TCService;

@Service
public class BN_TCServiceimpl implements BN_TCService {
	@Autowired
	private BN_TCRepository bN_TCRepository;

	@Override
	public List<BN_TC> findAll() {
		try {
			return this.bN_TCRepository.findAll();
		}
		catch (Exception e) {
			showerror("findAll()", e);
			// TODO: handle exception
			
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BN_TC> findByIdTC(String idTC) {
		// TODO Auto-generated method stub
		try {
			return this.bN_TCRepository.findByIdTC(idTC);
		} catch (Exception e) {
			// TODO: handle exception
			showerror("findByIdTC()", e);
		}
		
		return null;
	}

	
	public void showerror(String s,Exception e) {
		System.out.println(" Error "+  s+" in BN_TCService_impl : ");
		e.getMessage();
	}

	@Override
	public List<BN_TC> findByIdBN(String idBN) {
		// TODO Auto-generated method stub
		try {
			return this.bN_TCRepository.findByIdBN(idBN);
		} catch (Exception e) {
			// TODO: handle exception
			showerror("findByIdBN()", e);
		}
		return null;
	}

	@Override
	public boolean delete(BN_TC bn_TC) {
		// TODO Auto-generated method stub
		try {
			this.bN_TCRepository.delete(bn_TC);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			showerror("delete()", e);
		}
		return false;
	}

	@Override
	public boolean save(BN_TC bn_TC) {
		try {
			this.bN_TCRepository.save(bn_TC);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			showerror("save() ", e);
		}
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public float xuly(ArrayList<BoSo> listBNTC,ArrayList<BoSo> listTCB) {
		if(listBNTC.size()!=listTCB.size()) {
			System.out.println("dữ liệu bị lỗi, listBNTC không cùng kích thước với listTCB");
			return 0;
		}
		int n=listBNTC.size();
		float[] listResult=new float[3];// chứa kết quả
		float[] list1=new float[n];// gtri kd
		float[] list2=new float[n];//gtr tb
		float[] list3=new float[n];//gtr pd
 		for(int j=0;j<n;j++) {
 			System.out.println("tìm min LIST1"+listBNTC.get(j).getKd()+" "+ listBNTC.get(j).getKd());
			list1[j]=Math.min(listBNTC.get(j).getKd(), listTCB.get(j).getKd());
			System.out.println("tìm min LIST2"+listBNTC.get(j).getTb()+" "+ listBNTC.get(j).getTb());
			list2[j]=Math.min(listBNTC.get(j).getTb(), listTCB.get(j).getTb());
			System.out.println("tìm min LIST3"+listBNTC.get(j).getPd()+" "+ listBNTC.get(j).getPd());
			list3[j]=Math.min(listBNTC.get(j).getPd(), listTCB.get(j).getPd());
		}
 		for (float f : list1) {
			System.out.println(f);
		}
 		System.out.println("xong");
 		for (float f : list1) {
			System.out.println(f);
		}
 		System.out.println("xong");
 		for (float f : list1) {
			System.out.println(f);
		}
 		listResult[0]=findMax(list1);
 		listResult[1]=findMax(list2);
 		listResult[2]=findMax(list3);
		
		
		
		
		System.out.println("KẾT QUẢ TÍNH ĐƯỢC: "+listResult[0]+"   "+listResult[1]+"   "+listResult[2]);
		
		return listResult[0]-listResult[2]*(1-listResult[0]-listResult[1]-listResult[2]);
	}
	public float findMax(float[] list) {
		
		int n=list.length;
		if(n==0) return 0;
		float max=list[0];
		for(int i=1;i<n;i++) {
			if(list[i]>max) {
				max=list[i];
			}
		}
		
		return max;
	}
	

}
