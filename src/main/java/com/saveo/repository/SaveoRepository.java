package com.saveo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saveo.model.SaveoModel;

@Repository
public interface SaveoRepository  extends JpaRepository<SaveoModel, Integer>{
	

//	@Query("SELECT * FROM SaveoProduct WHERE c_name LIKE %:name%")

	List<SaveoModel>findAllByNameIgnoreCaseContaining(String name);

}
