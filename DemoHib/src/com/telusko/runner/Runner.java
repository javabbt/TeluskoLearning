package com.telusko.runner;

import java.util.ArrayList;

import com.telusko.model.AlienModel;
import com.telusko.jdbcDAO.AlienJDBCDAO;

public class Runner {


	public static void main(String[] args) {

		AlienJDBCDAO jdbclayer=new AlienJDBCDAO();

		/*  Get All Alien Objects */

		ArrayList<AlienModel> aliens=new ArrayList<AlienModel>();


		aliens=jdbclayer.getAllAliens();

		for(AlienModel a: aliens){

			System.out.println("aid="+a.getAid());
			System.out.println("aname="+a.getAname());
			System.out.println("tech="+a.getTech());

		}

		/*  Get Alien Object based on ID */

		AlienModel alien=new AlienModel();
		alien=jdbclayer.getAlien(101);

		System.out.println("aid="+alien.getAid());
		System.out.println("aname="+alien.getAname());
		System.out.println("tech="+alien.getTech());


		/* Delete a User  */
		jdbclayer.DeleteAlien(106);


		/* Insert into Alien Table */

		AlienModel newalien=new AlienModel();
		newalien.setAid(106);
		newalien.setAname(" 016 user");
		newalien.setTech("new tech 106");
		jdbclayer.insertAlien(newalien);



	}

}
