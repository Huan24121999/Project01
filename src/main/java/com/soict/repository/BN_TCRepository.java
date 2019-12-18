package com.soict.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soict.entities.BN_TC;


@Repository
public interface BN_TCRepository extends JpaRepository<BN_TC,String>{
    
	
	List<BN_TC> findByIdBN(String idBN);
	 
	List<BN_TC> findByIdTC(String idTC);

}
