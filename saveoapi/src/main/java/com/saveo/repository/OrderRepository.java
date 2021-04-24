package com.saveo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saveo.model.SaveoModel;
import com.saveo.model.SaveoOrderModel;

@Repository
public interface OrderRepository  extends JpaRepository<SaveoOrderModel, Integer>{

}
