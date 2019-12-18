package com.soict.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soict.entities.Benh;

@Repository
public interface BenhRepository extends JpaRepository<Benh, String> {
	
	List<Benh> findAll();
	
	Benh findByIdBenh(String idbenh);
	
	Benh findByTenBenh(String tenbenh);
	
}
