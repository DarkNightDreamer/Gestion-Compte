package com.rormation.gs.utils;

import com.rormation.gs.dao.PersonneDao;
import com.rormation.gs.dao.implimentation.PersonneDaoImpl;
import com.rormation.gs.entities.Personne;

public class Test {

	public static void main(String[] args) {
		
		Personne personne = new Personne ("178885","arra","ddd","bbb","eeee");
		PersonneDao personneDao = new PersonneDaoImpl();//declaration polymorphique
		
		try {
			personneDao.save(personne);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}

	}

}
