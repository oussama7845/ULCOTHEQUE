package com.univlittoral.projetback.dto;

import java.util.Map;


public class Genre_DTO {
	private Map<String,Integer> listeGenre;

    public Map<String, Integer> getListeGenre() {
        return listeGenre;
    }

    public void setListeGenre(Map<String, Integer> listeGenre) {
        this.listeGenre = listeGenre;
    }
	
}
