package com.training.crud.entity;

public class Message {
	private String status;
	private String ket;
	
	public Message() {
		
	}
	
	public Message(String status, String ket) {
		super();
		this.status = status;
		this.ket = ket;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getKet() {
		return ket;
	}
	public void setKet(String ket) {
		this.ket = ket;
	}
	
	
}
