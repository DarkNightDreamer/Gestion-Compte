package com.rormation.gs.services.impl;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.rormation.gs.dao.CompteDao;
import com.rormation.gs.dao.implimentation.CompteDaoImpl;
import com.rormation.gs.entities.Compte;
import com.rormation.gs.models.messageResponse;
import com.rormation.gs.services.CompteService;

public class CompteServiceImpl implements CompteService {
	
	//instance
	private CompteDao cptDao = new CompteDaoImpl();

	@Override
	public messageResponse save(Compte compte) throws Exception {
		
		cptDao.save(compte);
		
		return new messageResponse(true,"operation effectuee");
	}

	@Override
	public messageResponse upadte(Compte compte) throws Exception {
		
		cptDao.update(compte);
		return new messageResponse(true,"operation effectuee");
	}

	@Override
	public messageResponse delete(Compte compte) throws Exception {
		
		cptDao.delete(compte);
		return new messageResponse(true,"operation effectuee");
		
	}

	@Override
	public List<Compte> findAll() throws Exception {
		// TODO Auto-generated method stub
		return cptDao.findAll();
	}

}
