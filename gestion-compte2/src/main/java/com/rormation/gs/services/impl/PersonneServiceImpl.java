package com.rormation.gs.services.impl;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.rormation.gs.dao.PersonneDao;
import com.rormation.gs.dao.implimentation.PersonneDaoImpl;
import com.rormation.gs.entities.Personne;
import com.rormation.gs.models.messageResponse;
import com.rormation.gs.services.PersonneServicee;

public class PersonneServiceImpl implements PersonneServicee {

	private PersonneDao persDdao;
	private Criterion crit2;

	@Override
	public messageResponse save(Personne personne) throws Exception {

		Personne pers = persDdao.findById(personne.getCin());
		if (pers != null) {
			return new messageResponse(false, "CIN existant");
		}

		// crit par email
		Criterion crit = Restrictions.eq("email", personne.getEmail());
		List<Personne> list = persDdao.findByCriteria(crit);

		if (!list.isEmpty()) {
			return new messageResponse(false, "email existant");

		}

		// else
		persDdao.save(personne);
		return new messageResponse(true, "peration effectuée avec succée");

	}

	@Override
	public messageResponse upadte(Personne personne) throws Exception {

		Criterion crit1 = Restrictions.idEq(personne.getCin());
		Criterion crit2 = Restrictions.eq("email", personne.getEmail());
		Criterion crit = Restrictions.and(crit1, crit2);
		List<Personne> list = persDdao.findByCriteria(crit);

		if (list.isEmpty()) {
			// lawej bel email
			list = persDdao.findByCriteria(crit2);
			if (!list.isEmpty()) {
				return new messageResponse(false, "email existant");
			}

		}

		persDdao.update(personne);
		return new messageResponse(false, "email existant");

	}

	@Override
	public messageResponse delete(Personne personne) throws Exception {
		 Criterion  crit = Restrictions.isNotEmpty("comptes");
		  List<Personne> list = persDdao.findByCriteria(crit);
		  if(!list.isEmpty()) {
			  return new messageResponse(false,"Personne a un ou +sieures compte");
		  }
		  persDdao.delete(personne);
		return new messageResponse(true,"operation effectuee");
		
	}
	@Override
	public List<Personne> findAll(Personne personne) throws Exception {

		return persDdao.findAll() ;
	}

	public PersonneDao getPersDdao() {
		return persDdao;
	}

	public void setPersDdao(PersonneDao persDdao) {
		this.persDdao = persDdao;
	}

	
}
