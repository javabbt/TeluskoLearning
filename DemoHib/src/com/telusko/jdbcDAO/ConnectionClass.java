package com.telusko.jdbcDAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {

	private String username="nandu";
	private String password="nandu";
	private String dbname="bit";

	static Connection con=null;




	public Connection getConnection() {

		if(con!=null){return con;}else{

			return createConnection(dbname,username,password);
		}



	}

	private static Connection createConnection(String database, String username,String password) {

		Connection conn = null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");  
			conn=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/"+database,username,password);  
		}catch(Exception e){
			System.out.println("Error Thrown while Creating Conenction "+e.toString());
		}
		return conn;
	}


}
