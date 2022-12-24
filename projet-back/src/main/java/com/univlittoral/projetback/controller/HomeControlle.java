package com.univlittoral.projetback.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.univlittoral.projetback.dto.Auteur_DTO;
import com.univlittoral.projetback.dto.Categorie_DTO;
import com.univlittoral.projetback.dto.Genre_DTO;
import com.univlittoral.projetback.dto.Home_DTO;
import com.univlittoral.projetback.dto.Indicateurs_DTO;
import com.univlittoral.projetback.dto.Livre_DTO;
import com.univlittoral.projetback.entity.Auteur_Entity;
import com.univlittoral.projetback.entity.Livre_Entity;
import com.univlittoral.projetback.enums.Genre_Enums;
import com.univlittoral.projetback.mapper.Auteur_Mapper;
import com.univlittoral.projetback.mapper.Livre_Mapper;
import com.univlittoral.projetback.service.Auteur_Service;
import com.univlittoral.projetback.service.Livre_Service;

@RestController
@RequestMapping(value ="/rest/bd/home")
@Transactional
public class HomeControlle {
	
	@Autowired 
	private Livre_Service livreBO;
	@Autowired 
	private Auteur_Service auteurBO;
	
	@GetMapping
	public Home_DTO getHomePage() {
		final List<Livre_Entity> livresEntities = livreBO.findAll() ;
        final ArrayList<String> genres = new ArrayList<String>();
        final Map<String, Integer> tabListeGenre = new HashMap();
        final Home_DTO dto = new Home_DTO();
        final Indicateurs_DTO indicateur = new Indicateurs_DTO();
        indicateur.setNbLivres(livresEntities.size());
        indicateur.setNbAuteurs(auteurBO.findAll().size());


        for (int i = 0; i < livresEntities.size(); i++) {
                Livre_Entity livre = livresEntities.get(i);
                String genre =  livre.getGenre().toString();
              boolean contains = genres.contains(genre);
                if(!contains) {
                    genres.add(genre.toString());
                }
            }


        for (int i = 0; i < livresEntities.size(); i++) {
            Livre_Entity livre = livresEntities.get(i);
            String genre =  livre.getGenre().toString();
          boolean contains = tabListeGenre.containsKey(genre);
            if(!contains) {
                tabListeGenre.put(genre, 1);
            }
            else{
                tabListeGenre.put(genre, tabListeGenre.get(genre) + 1);
            }

        }


        dto.setLivres(new ArrayList<>(Livre_Mapper.map(livresEntities)));
        dto.setIndicateurs(indicateur);
        indicateur.setNbGenres(genres.size());

        final Genre_DTO listeGenre = new Genre_DTO();
        listeGenre.setListeGenre(tabListeGenre);
        dto.setGenres(tabListeGenre);

        return dto;
    }
	
}
