package com.training.crud.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.crud.core.CoreController;
import com.training.crud.entity.Mahasiswa;
import com.training.crud.entity.Message;
import com.training.crud.service.MahasiswaService;

public class MahasiswaController extends CoreController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MahasiswaService mhsService = new MahasiswaService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = req.getParameter("action");
		HashMap<String, String> kondisi = new HashMap<>();
		HashMap<String, Object> param = new HashMap<>();
		Message msg;
		if (action != null) {
			switch (action.toLowerCase()) {
			case "index":
				param.put("mhs", mhsService.findAll("*"));
				title = "Daftar Mahasiswa";
				renderView("mahasiswa/index", req, resp, param);
				break;
			case "list-ajax":
				renderJson(mhsService.findAll("*"), resp);
				break;
			case "create":
				title = "Tambah Mahasiswa Baru";
				renderView("mahasiswa/form", req, resp, param);
				break;
			case "update":
				kondisi.put("nim", req.getParameter("key"));
				param.put("mhs", mhsService.findOne("*", kondisi));
				title = "Ubah Data Mahasiswa";
				renderView("mahasiswa/form", req, resp, param);
				break;
			case "edit-ajax":
				kondisi.put("nim", req.getParameter("key"));
				renderJson(mhsService.findOne("*", kondisi), resp);
				break;
			case "delete":
				mhsService.delete(req.getParameter("key"));
				redirect(resp, "mahasiswa.html?action=index");
				break;
			case "delete-ajax":
				mhsService.delete(req.getParameter("key"));
				msg = new Message("success", "Data Berhasil didelete");
				renderJson(msg, resp);
				break;
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = req.getParameter("action");
		Message msg;
		if (action != null) {
			switch (action.toLowerCase()) {
			case "create":
				save(req);
				redirect(resp, "mahasiswa.html?action=index");
				break;
			case "save-ajax":
				save(req);
				msg = new Message("success", "Data Berhasil disimpan");
				renderJson(msg, resp);
				break;
			case "update":
				updateData(req);
				redirect(resp, "mahasiswa.html?action=index");
				break;
			case "update-ajax":
				updateData(req);
				msg = new Message("success", "Data Berhasil diupdate");
				renderJson(msg, resp);
				break;
			}
		}
	}

	private void save(HttpServletRequest req) {
		MahasiswaService mhsService = new MahasiswaService();
		Mahasiswa mhs = new Mahasiswa();
		mhs.setNim(req.getParameter("nim"));
		mhs.setNama(req.getParameter("nama"));
		mhs.setEmail(req.getParameter("email"));
		mhs.setProdi(req.getParameter("prodi"));
		mhsService.save(mhs);
	}

	private void updateData(HttpServletRequest req) {
		MahasiswaService mhsService = new MahasiswaService();
		Mahasiswa mhs = new Mahasiswa();
		mhs.setNim(req.getParameter("nim"));
		mhs.setNama(req.getParameter("nama"));
		mhs.setEmail(req.getParameter("email"));
		mhs.setProdi(req.getParameter("prodi"));
		mhsService.update(mhs, req.getParameter("key"));
	}
}
