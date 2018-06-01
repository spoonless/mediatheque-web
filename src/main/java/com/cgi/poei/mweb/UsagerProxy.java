package com.cgi.poei.mweb;

import javax.xml.bind.annotation.XmlRootElement;

import com.cgi.poei.mediatheque.Usager;

@XmlRootElement(name="usager")
public class UsagerProxy {
	
	private Usager usager;
	
	public UsagerProxy() {
	}
	
	public UsagerProxy(Usager usager) {
		this.usager = usager;
	}

	public String getNom() {
		return usager.getNom();
	}
	
	public void setNom(String nom) {
		usager.setNom(nom);
	}

	public String getPrenom() {
		return usager.getPrenom();
	}

	public void setPrenom(String prenom) {
		usager.setPrenom(prenom);
	}

	public String getNomComplet() {
		return usager.getNomComplet();
	}

}
