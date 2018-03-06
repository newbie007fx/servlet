package com.training.crud.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.training.crud.core.CoreModel;
import com.training.crud.entity.Mahasiswa;

public class MahasiswaDao extends CoreModel{
	
	@Override
	protected String tableName() {
		// TODO Auto-generated method stub
		return "mahasiswa";
	}
	
	@Override
	protected String primaryKey() {
		// TODO Auto-generated method stub
		return "nim";
	}
	
	@Override
	protected String[] field() {
		String[] field = new String[4];
		field[0] = "nim";
		field[1] ="nama";
		field[2] ="email";
		field[3] ="prodi";
		return field;
	}
	
	public void insertData(Mahasiswa mhs) {	
		try {
			PreparedStatement ps = buildPrepare("insert");
			ps.setString(1, mhs.getNim().toString());
			ps.setString(2, mhs.getNama().toString());
			ps.setString(3, mhs.getEmail().toString());
			ps.setString(4, mhs.getProdi().toString());
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateData(Mahasiswa mhs, String key) {	
		try {
			PreparedStatement ps = buildPrepare("update");
			ps.setString(1, mhs.getNim().toString());
			ps.setString(2, mhs.getNama().toString());
			ps.setString(3, mhs.getEmail().toString());
			ps.setString(4, mhs.getProdi().toString());
			ps.setString(5, key);
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteData(String key) {
		try {
			PreparedStatement ps = buildPrepare("delete");
			ps.setString(1, key);
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Mahasiswa selectOne(String field) {
		try {
			ResultSet rs = select(field);
			if(rs.next()) {
				Mahasiswa mhs = new Mahasiswa(rs.getString("nim"), rs.getString("nama"), rs.getString("email"), rs.getString("prodi"));
				return mhs;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Mahasiswa> selectAll(String field) {
		try {
			ResultSet rs = select(field);
			List<Mahasiswa> mhsList = new ArrayList<>();
			while(rs.next()) {
				Mahasiswa mhs = new Mahasiswa(rs.getString("nim"), rs.getString("nama"), rs.getString("email"), rs.getString("prodi"));
				mhsList.add(mhs);
			}
			return mhsList;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
