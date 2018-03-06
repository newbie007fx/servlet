package com.training.crud.entity;

public class Departemen {
	private int id;
	private String namaDepartemen;
	private String alamat;
	private String website;
	
	public Departemen() {
		
	}
	
	public Departemen(int id, String namaDepartemen, String alamat, String website) {
		super();
		this.id = id;
		this.namaDepartemen = namaDepartemen;
		this.alamat = alamat;
		this.website = website;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNamaDepartemen() {
		return namaDepartemen;
	}
	public void setNamaDepartemen(String namaDepartemen) {
		this.namaDepartemen = namaDepartemen;
	}
	public String getAlamat() {
		return alamat;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
}
