package com.training.crud.entity;

public class Mahasiswa {
	private String nim;
	private String nama;
	private String email;
	private String prodi;
	
	public Mahasiswa() {
		
	}
	
	public Mahasiswa(String nim, String nama, String email, String prodi) {
		super();
		this.nim = nim;
		this.nama = nama;
		this.email = email;
		this.prodi = prodi;
	}
	public String getNim() {
		return nim;
	}
	public void setNim(String nim) {
		this.nim = nim;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProdi() {
		return prodi;
	}
	public void setProdi(String prodi) {
		this.prodi = prodi;
	}

	@Override
	public String toString() {
		return "Mahasiswa [nim=" + nim + ", nama=" + nama + ", email=" + email + ", prodi=" + prodi + "]";
	}
	
	
}
