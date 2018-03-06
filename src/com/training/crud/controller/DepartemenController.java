package com.training.crud.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.crud.core.CoreController;
import com.training.crud.entity.Departemen;
import com.training.crud.service.DepartemenService;

public class DepartemenController extends CoreController {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private DepartemenService dptService = new DepartemenService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = req.getParameter("action");
		HashMap<String, Object> param = new HashMap<>();
		if (action != null) {
			switch (action.toLowerCase()) {
			case "index":
				param.put("dpt", dptService.findAll("*"));
				title = "Daftar Departemen";
				renderView("departemen/index", req, resp, param);
				break;
			case "create":
				title = "Tambah Departemen Baru";
				renderView("departemen/form", req, resp, param);
				break;
			case "update":
				HashMap<String, String> kondisi = new HashMap<>();
				kondisi.put("id", req.getParameter("key"));
				param.put("dpt", dptService.findOne("*", kondisi));
				title = "Ubah Data Departemen";
				renderView("departemen/form", req, resp, param);
				break;
			case "delete":
				dptService.delete(req.getParameter("key"));
				redirect(resp, "departemen.html?action=index");
				break;
			}
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = req.getParameter("action");
		if (action != null) {
			switch (action.toLowerCase()) {
			case "create":
					save(req);
					redirect(resp, "departemen.html?action=index");
				break;
			case "update":
				updateData(req);
				redirect(resp, "departemen.html?action=index");
			break;
			}
		}
	}
	
	private void save(HttpServletRequest req) {
		DepartemenService dptService = new DepartemenService();
		Departemen dpt = new Departemen();
		dpt.setId(Integer.parseInt(req.getParameter("id")));
		dpt.setNamaDepartemen(req.getParameter("nama_departemen"));
		dpt.setAlamat(req.getParameter("alamat"));
		dpt.setWebsite(req.getParameter("website"));
		dptService.save(dpt);
	}
	
	private void updateData(HttpServletRequest req) {
		DepartemenService dptService = new DepartemenService();
		Departemen dpt = new Departemen();
		dpt.setId(Integer.parseInt(req.getParameter("id")));
		dpt.setNamaDepartemen(req.getParameter("nama_departemen"));
		dpt.setAlamat(req.getParameter("alamat"));
		dpt.setWebsite(req.getParameter("website"));
		dptService.update(dpt, req.getParameter("key"));
	}
}
