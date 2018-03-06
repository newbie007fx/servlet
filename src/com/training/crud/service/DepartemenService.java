package com.training.crud.service;

import java.util.HashMap;
import java.util.List;

import com.training.crud.dao.DepartemenDao;
import com.training.crud.entity.Departemen;

public class DepartemenService {
	DepartemenDao dptDao = new DepartemenDao();
	
	public List<Departemen> findAll(String field){
		return dptDao.selectAll(field);
	}
	
	public Departemen findOne(String field, HashMap<String, String> kondisi) {
		dptDao.where(kondisi);
		return dptDao.selectOne(field);
	}
	
	public void save(Departemen dpt) {
		dptDao.insertData(dpt);
	}
	
	public void update(Departemen dpt, String key) {
		dptDao.updateData(dpt, key);
	}
	
	public void delete(String key) {
		dptDao.deleteData(key);
	}
}
