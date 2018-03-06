package com.training.crud.service;

import java.util.HashMap;
import java.util.List;

import com.training.crud.dao.MahasiswaDao;
import com.training.crud.entity.Mahasiswa;

public class MahasiswaService {
	MahasiswaDao mhsDao = new MahasiswaDao();
	
	public List<Mahasiswa> findAll(String field){
		return mhsDao.selectAll(field);
	}
	
	public Mahasiswa findOne(String field, HashMap<String, String> kondisi) {
		mhsDao.where(kondisi);
		return mhsDao.selectOne(field);
	}
	
	public void save(Mahasiswa mhs) {
		mhsDao.insertData(mhs);
	}
	
	public void update(Mahasiswa mhs, String key) {
		mhsDao.updateData(mhs, key);
	}
	
	public void delete(String key) {
		mhsDao.deleteData(key);
	}
}
