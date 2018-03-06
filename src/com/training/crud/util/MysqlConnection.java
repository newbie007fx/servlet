package com.training.crud.util;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

public final class MysqlConnection {
	public Connection conn;
	public static MysqlConnection db;
    private MysqlConnection() {
        String url= "jdbc:mysql://localhost:3306/";
        String dbName = "simple_crud";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "";
        try {
            Class.forName(driver).newInstance();
            this.conn = (Connection)DriverManager.getConnection(url+dbName,userName,password);
        }
        catch (Exception sqle) {
            sqle.printStackTrace();
        }
    }
    
    public static synchronized MysqlConnection getDbCon() {
        if ( db == null ) {
            db = new MysqlConnection();
        }
        return db;
 
    }
}
