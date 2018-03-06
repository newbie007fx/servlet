package com.training.crud.core;

import com.mysql.jdbc.Connection;
import com.training.crud.util.MysqlConnection;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public abstract class CoreModel {

	private Connection conn;
	private String where;
	private HashMap<Integer, String> whereData;

	public CoreModel() {
		where ="";
		conn = MysqlConnection.getDbCon().conn;
	}

	protected abstract String tableName();

	protected abstract String[] field();
	
	protected abstract String primaryKey();

	public void where(HashMap<String, String> value) {
		where = " where ";
		int panjang = value.size();
		StringBuilder nameBuilder = new StringBuilder();
		int i = 1;
		whereData = new HashMap<>();
		for(Map.Entry<String, String> entry : value.entrySet()) {
		    String key = entry.getKey();
		    String val = entry.getValue();
		    whereData.put(i, val);
		    nameBuilder.append(key).append("=? ");
		    if(i < panjang) {
		    	nameBuilder.append("and ");
		    }
		    i++;
		}
		where += nameBuilder.toString();
	}
	
	public ResultSet select(String field) throws SQLException {
		String query = "select "+field+" from "+tableName()+where;
		PreparedStatement ps = conn.prepareStatement(query);
		if(! where.equals("")) {
			for(Map.Entry<Integer, String> entry : whereData.entrySet()) {
				int key = entry.getKey();
			    String val = entry.getValue();
			    ps.setString(key, val);
			}
			where ="";
		}
		return ps.executeQuery();
	}
	
	protected PreparedStatement buildPrepare(String act) throws SQLException {
		String query = "";
		switch(act) {
		case "insert":
			query = this.buildInsertQuery();
			break;
		case "update":
			query = this.buildUpdateQuery();
			break;
		case "delete":
			query = this.buildDeleteQuery();
			break;
		}
		PreparedStatement ps = conn.prepareStatement(query);
			return ps;
	}

	protected String buildInsertQuery() {
		if (field().length > 0) {
			StringBuilder nameBuilder = new StringBuilder();
			for (String n : field()) {
				nameBuilder.append(n).append("=?,");
			}
			nameBuilder.deleteCharAt(nameBuilder.length() - 1);
			String query = "insert into " + tableName() + " set " + nameBuilder.toString() + "";
			return query;
		} else {
			return "";
		}
	}
	
	protected String buildUpdateQuery() {
		if (field().length > 0) {
			StringBuilder nameBuilder = new StringBuilder();
			for (String n : field()) {
				nameBuilder.append(n).append("=?,");
			}
			nameBuilder.deleteCharAt(nameBuilder.length() - 1);
			String query = "update " + tableName() + " set " + nameBuilder.toString() + " where "+primaryKey()+"=?";
			return query;
		} else {
			return "";
		}
	}
	
	protected String buildDeleteQuery() {
			String query = "delete from " + tableName() + " where "+primaryKey()+"=?";
			return query;
	}
}
