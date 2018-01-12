package com.telusko.jdbcDAO;

public class QueryInterface {

	public String getAllAliensSelectQuery() {

		String query="select * from alien";

		return query;
	}

	public String getAlienSelectQuery() {

		String query="select * from alien where aid=?";

		return query;



	}

	public String getAlienInsertQuery() {
		
		String query="insert into alien(aid,aname,tech)values(?,?,?)";
		
		return query;
	}

	public String getDeleteAlienQuery() {
		
		String query="delete from alien where aid=?";
		
		return query;
	}

}
