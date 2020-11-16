package com.rormation.gs.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.rormation.gs.entities.Personne;
import com.rormation.gs.services.PersonneServicee;
import com.rormation.gs.services.impl.PersonneServiceImpl;

//definition du classe as controller
@ManagedBean
@ViewScoped
public class PersonneBean implements Serializable {

	// var
	private Personne personne = new Personne();
	@ManagedProperty(value="#{perServ}")
	private PersonneServicee personneService;
	private List<Personne> list = new ArrayList<>();
	private boolean btnAdd = true;
	private boolean btnEdit = false;

	// methode

	public void clickEdit() {
		btnAdd = false;
		btnEdit = true;

	}
	public void annuler() {
		personne = new Personne();
		btnAdd = true;
		btnEdit = false;
		

	}

	public void ajouter() {
		try {
			personneService.save(personne);
			// bech najem nzid objet viewscooped
			personne = new Personne();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void modifier() {
		try {
			personneService.upadte(personne);
			// bech najem nzid objet viewscooped
			//personne = new Personne();
			annuler();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void supprimer() {
		try {
			personneService.delete(personne);
			// bech najem nzid objet viewscooped
			personne = new Personne();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// getSet

	public Personne getPersonne() {
		return personne;
	}

	public List<Personne> getList() {

		try {
			list = personneService.findAll(personne);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public void setList(List<Personne> list) {
		this.list = list;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	public boolean isBtnAdd() {
		return btnAdd;
	}

	public void setBtnAdd(boolean btnAdd) {
		this.btnAdd = btnAdd;
	}

	public boolean isBtnEdit() {
		return btnEdit;
	}

	public void setBtnEdit(boolean btnEdit) {
		this.btnEdit = btnEdit;
	}
	public PersonneServicee getPersonneService() {
		return personneService;
	}
	public void setPersonneService(PersonneServicee personneService) {
		this.personneService = personneService;
	}

}
