package com.saveo.service;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.saveo.UploadCSV;
import com.saveo.model.SaveoModel;
import com.saveo.model.SaveoOrderModel;
import com.saveo.repository.OrderRepository;
import com.saveo.repository.SaveoRepository;

@Service
public class SaveoService {
  @Autowired
  SaveoRepository repository;

  public void save(MultipartFile file) {
    try {
      List<SaveoModel> saveoList = UploadCSV.dbUpload(file.getInputStream());
      repository.saveAll(saveoList);
    } catch (IOException e) {
      throw new RuntimeException("Some Error " + e.getMessage());
    }
  }

 
  @Autowired
  OrderRepository rep;
  public SaveoOrderModel order(SaveoOrderModel od) {
     return rep.save(od);
  }
public SaveoModel getMedicineDetails(int id) {
	// TODO Auto-generated method stub
	return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Id:" + id));
}
public List<SaveoModel> searchMedicine(String name) {
	// TODO Auto-generated method stub
	return repository.findAllByNameIgnoreCaseContaining(name);
};
}

