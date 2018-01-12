package com.telusko.jdbcDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.telusko.model.AlienModel;

public class AlienJDBCDAO {

	ConnectionClass connectionobject=new ConnectionClass();
	QueryInterface query=new QueryInterface();
	Connection con=connectionobject.getConnection();
	PreparedStatement stmt;
	ResultSet rs;

	public  ArrayList<AlienModel> getAllAliens() {

		ArrayList<AlienModel> aliens=new ArrayList<AlienModel>();

		try{

			String selectSQL = query.getAllAliensSelectQuery();
			stmt = con.prepareStatement(selectSQL);
			rs = stmt.executeQuery(selectSQL);


			while (rs.next()) {

				AlienModel alien =new AlienModel();
				alien.setAid(rs.getInt(1));
				alien.setAname(rs.getString(2));	
				alien.setTech(rs.getString(3));	

				aliens.add(alien);
			}




		}catch(Exception e){

			System.out.println("Exception in getAllAliens Method : "+e.toString());
		}finally{

			try{

				if(stmt!=null){stmt.close();}
				if(rs!=null){rs.close();}


			}catch(Exception ex){

			}

		}



		return aliens;
	}

	public AlienModel getAlien(int aid) {

		AlienModel alien=new AlienModel();

		try{

			String selectSQL = query.getAlienSelectQuery();
			stmt = con.prepareStatement(selectSQL);
			stmt.setInt(1, aid);
			rs = stmt.executeQuery();


			while (rs.next()) {


				alien.setAid(rs.getInt(1));
				alien.setAname(rs.getString(2));	
				alien.setTech(rs.getString(3));	

			}




		}catch(Exception e){

			System.out.println("Exception in getAlien Method : "+e.toString());
		}finally{

			try{

				if(stmt!=null){stmt.close();}
				if(rs!=null){rs.close();}


			}catch(Exception ex){

			}

		}



		return alien;
	}

	public void insertAlien(AlienModel newalien) {


		try{

			String selectSQL = query.getAlienInsertQuery();
			stmt = con.prepareStatement(selectSQL);
			stmt.setInt(1, newalien.getAid());
			stmt.setString(2, newalien.getAname());
			stmt.setString(3, newalien.getTech());
			int i = stmt.executeUpdate();


			System.out.println("insertAlien Status is "+i);




		}catch(Exception e){

			System.out.println("Exception in insertAlien Method : "+e.toString());
		}finally{

			try{

				if(stmt!=null){stmt.close();}
				if(rs!=null){rs.close();}


			}catch(Exception ex){

			}

		}


	}

	public void DeleteAlien(int aid) {


		try{

			String selectSQL = query.getDeleteAlienQuery();
			stmt = con.prepareStatement(selectSQL);
			stmt.setInt(1, aid);
			int i = stmt.executeUpdate();


			System.out.println("DeleteAlien Status is "+i);




		}catch(Exception e){

			System.out.println("Exception in DeleteAlien Method : "+e.toString());
		}finally{

			try{

				if(stmt!=null){stmt.close();}
				if(rs!=null){rs.close();}


			}catch(Exception ex){

			}

		}




	}









}
