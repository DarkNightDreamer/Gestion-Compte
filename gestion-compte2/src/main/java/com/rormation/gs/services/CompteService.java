package com.rormation.gs.services;

import java.util.List;

import com.rormation.gs.entities.Compte;
import com.rormation.gs.models.messageResponse;

public interface CompteService {
	public messageResponse save (Compte compte) throws Exception ;
	public messageResponse upadte ( Compte compte) throws Exception ;
	public messageResponse delete ( Compte compte) throws Exception  ;
	public List<Compte> findAll () throws Exception  ;

}
