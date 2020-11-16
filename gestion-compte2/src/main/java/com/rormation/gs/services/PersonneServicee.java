package com.rormation.gs.services;

import java.util.List;

import com.rormation.gs.entities.Personne;
import com.rormation.gs.models.messageResponse;

public interface PersonneServicee  {

	public messageResponse save (Personne personne ) throws Exception ;
	public messageResponse upadte (Personne personne ) throws Exception ;
	public messageResponse delete (Personne personne ) throws Exception  ;
	public List<Personne> findAll (Personne personne ) throws Exception  ;
}
