package com.soict.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soict.entities.TrieuChung;

@Repository
public interface TrieuChungRepository extends JpaRepository<TrieuChung,String>{
	TrieuChung  findByIdTC(String idTC);
	
	TrieuChung  findByTenTC(String tenTC);

	

}
