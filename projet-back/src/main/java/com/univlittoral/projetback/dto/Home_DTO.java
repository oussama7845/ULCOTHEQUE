package com.univlittoral.projetback.dto;

import java.util.List;
import java.util.Map;

public class Home_DTO {
	List<Livre_DTO> livres;
    Indicateurs_DTO indicateurs;
    Map<String,Integer> genres;
    
	public List<Livre_DTO> getLivres() {
		return livres;
	}
	public void setLivres(List<Livre_DTO> livres) {
		this.livres = livres;
	}
	public Indicateurs_DTO getIndicateurs() {
		return indicateurs;
	}
	public void setIndicateurs(Indicateurs_DTO indicateur) {
		indicateurs = indicateur;
	}
	
	public Map<String,Integer> getGenres() {
		return genres;
	}
	public void setGenres(Map<String,Integer> genres) {
		this.genres = genres;
	}

	
	
	
	
    
    
    
}