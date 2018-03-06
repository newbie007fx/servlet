package com.training.crud.core;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class CoreController extends javax.servlet.http.HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String base_url = "http://localhost:8085/simple-crud/";
	protected String title="";
	
	protected void renderView(String view, HttpServletRequest req,HttpServletResponse resp, HashMap<String, Object> param) 
	throws IOException, ServletException{
		req.setAttribute("title", title);
		for(Map.Entry<String, Object> entry : param.entrySet()) {
			req.setAttribute(entry.getKey(), entry.getValue());
		}
		RequestDispatcher dispatch = req.getRequestDispatcher("WEB-INF/"+view+".jsp");
		dispatch.forward(req, resp);
	}
	
	protected void renderJson(Object ojt, HttpServletResponse resp) throws IOException {
		resp.setContentType("application/json;charset=UTF-8");
        ServletOutputStream out = resp.getOutputStream();
        Gson gson = new GsonBuilder().create();
        JsonObject jsonObject = new JsonObject();
        if(ojt instanceof List) {
        	JsonArray jarray = gson.toJsonTree(ojt).getAsJsonArray();
        	jsonObject.add("data", jarray);
        }else {
        	jsonObject.add("data", gson.toJsonTree(ojt));
        }
        
        out.print(jsonObject.toString());
	}
	
	protected void redirect(HttpServletResponse resp, String url)throws IOException, ServletException{
		resp.sendRedirect(resp.encodeRedirectURL(base_url+url));
	}
}
