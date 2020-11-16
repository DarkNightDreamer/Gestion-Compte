package com.rormation.gs.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletContext;

import com.rormation.gs.entities.Compte;
import com.rormation.gs.entities.Personne;
import com.rormation.gs.models.messageResponse;
import com.rormation.gs.services.CompteService;
import com.rormation.gs.services.impl.CompteServiceImpl;

@ManagedBean
@ViewScoped
public class CompteBean implements Serializable {

	private CompteService compteService = new CompteServiceImpl();
	private List<Compte> list = new ArrayList<>();
	private Compte compte = new Compte();
	
	
	private boolean btnAdd = true;
	private boolean btnEdit = false;

	// methode

	public void clickEdit() {
		btnAdd = false;
		btnEdit = true;

	}
	public void clickAdd() {
		btnAdd = true;
		btnEdit = false;
        compte = new Compte();
	}
	public void ajouter() {
		
		try {
			messageResponse result = compteService.save(compte);
			
			if (result.isSuccess())
			{
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Info:" ,result.getMessage()));
				
			}else {
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN,"Attention:" ,result.getMessage()));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erreur:" ,"Operation nn effectuee"));
			e.printStackTrace();
		}
		
	}
	
	
public void supprimer() {
		
		try {
			messageResponse result = compteService.delete(compte);
			
			if (result.isSuccess())
			{
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Info:" ,result.getMessage()));
				
			}else {
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN,"Attention:" ,result.getMessage()));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erreur:" ,"Operation nn effectuee"));
			e.printStackTrace();
		}
		
	}

public void modifier() {
	
	try {
		messageResponse result = compteService.upadte(compte);
		
		if (result.isSuccess())
		{
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Info:" ,result.getMessage()));
			
		}else {
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN,"Attention:" ,result.getMessage()));
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erreur:" ,"Operation nn effectuee"));
		e.printStackTrace();
	}
	
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

	public List<Compte> getList() {
		
		try {
			list = compteService.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public void setList(List<Compte> list) {
		this.list = list;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	

}
