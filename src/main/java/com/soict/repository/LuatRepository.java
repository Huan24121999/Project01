package com.soict.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.soict.entities.Luat;

@Repository
public interface LuatRepository  extends JpaRepository<Luat, String>{
	List<Luat> findAll();
	
	List<Luat> findByIdBenh(String idBenh);
	 
	List<Luat> findByIdTC(String idTC);
	
	
	
	@Modifying
	@Query(value = "select * from project01.luat where idTC= ?1 and idBenh=?2",nativeQuery = true)
	List<Luat> search(String firstname, String lastname);
	
	
	
	
}
