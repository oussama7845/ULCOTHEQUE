package com.univlittoral.projetback.dto;

import java.util.Date;


import com.univlittoral.projetback.enums.*;


public class Livre_DTO {
	private Long id;
	private String nom;
	private String editeur;
	private Integer nbPages;
	private Date dateParution;
	private String lieuParution;
	private Genre_Enums genre;
	private Auteur_DTO auteur;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEditeur() {
		return editeur;
	}
	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}
	public Integer getNbPages() {
		return nbPages;
	}
	public void setNbPages(Integer nbPages) {
		this.nbPages = nbPages;
	}
	public Date getDateParution() {
		return dateParution;
	}
	public void setDateParution(Date dateParution) {
		this.dateParution = dateParution;
	}
	public String getLieuParution() {
		return lieuParution;
	}
	public void setLieuParution(String lieuParution) {
		this.lieuParution = lieuParution;
	}
	public Genre_Enums getGenre() {
		return genre;
	}
	public void setGenre(Genre_Enums genre) {
		this.genre = genre;
	}

	public Auteur_DTO getAuteur() {
		return auteur;
	}

	public void setAuteur(Auteur_DTO auteur) {
		this.auteur = auteur;
	}	
	
	
	
}
