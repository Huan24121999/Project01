package com.soict.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soict.entities.KeDon;

@Repository
public interface KeDonRepository extends JpaRepository<KeDon,String>{
	List<KeDon> findAll();
	
	KeDon findByIdDon(String idDon);
	
	KeDon findByIdBenh(String idBenh);

}
