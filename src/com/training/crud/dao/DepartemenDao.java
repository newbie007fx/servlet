package com.training.crud.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.training.crud.core.CoreModel;
import com.training.crud.entity.Departemen;

public class DepartemenDao extends CoreModel{
	
	@Override
	protected String tableName() {
		// TODO Auto-generated method stub
		return "departemen";
	}
	
	@Override
	protected String primaryKey() {
		// TODO Auto-generated method stub
		return "id";
	}
	
	@Override
	protected String[] field() {
		String[] field = new String[4];
		field[0] = "id";
		field[1] ="nama_departemen";
		field[2] ="alamat";
		field[3] ="website";
		return field;
	}
	
	public void insertData(Departemen dpt) {	
		try {
			PreparedStatement ps = buildPrepare("insert");
			ps.setInt(1, dpt.getId());
			ps.setString(2, dpt.getNamaDepartemen().toString());
			ps.setString(3, dpt.getAlamat().toString());
			ps.setString(4, dpt.getWebsite().toString());
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateData(Departemen dpt, String key) {	
		try {
			PreparedStatement ps = buildPrepare("update");
			ps.setInt(1, dpt.getId());
			ps.setString(2, dpt.getNamaDepartemen().toString());
			ps.setString(3, dpt.getAlamat().toString());
			ps.setString(4, dpt.getWebsite().toString());
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
	
	public Departemen selectOne(String field) {
		try {
			ResultSet rs = select(field);
			if(rs.next()) {
				Departemen dpt = new Departemen(rs.getInt("id"), rs.getString("nama_departemen"), rs.getString("alamat"), rs.getString("website"));
				return dpt;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Departemen> selectAll(String field) {
		try {
			ResultSet rs = select(field);
			List<Departemen> dptList = new ArrayList<>();
			while(rs.next()) {
				Departemen dpt = new Departemen(rs.getInt("id"), rs.getString("nama_departemen"), rs.getString("alamat"), rs.getString("website"));
				dptList.add(dpt);
			}
			return dptList;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
