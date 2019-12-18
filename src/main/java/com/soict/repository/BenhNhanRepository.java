package com.soict.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soict.entities.BenhNhan;

@Repository
public interface BenhNhanRepository  extends JpaRepository<BenhNhan, String>{
	List<BenhNhan> findAll();
	
	List<BenhNhan> findByTenBN(String tenBN);
	
	List<BenhNhan> findByDiachiBN(String diachiBN);
	
	BenhNhan findByCmnd(String cmnd);
	
	BenhNhan findByIdBN(String idBN);

}
