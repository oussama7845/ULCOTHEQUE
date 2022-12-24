package com.univlittoral.projetback.controller;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.univlittoral.projetback.dto.Auteur_DTO;
import com.univlittoral.projetback.entity.Auteur_Entity;
import com.univlittoral.projetback.mapper.Auteur_Mapper;
import com.univlittoral.projetback.service.Auteur_Service;


@RestController
@RequestMapping(value ="/rest/bd/auteurs")
@Transactional
public class AuteurControlle {
	@Autowired 
	private Auteur_Service auteurBO;
	
	 @GetMapping
	    public List<Auteur_DTO> getAuteursPage() {
	    	final List<Auteur_Entity> entities = auteurBO.findAll();
			List<Auteur_DTO> test = new ArrayList<Auteur_DTO>();
			test = new ArrayList<>(Auteur_Mapper.map(entities));
			
			return test;
	    }
	
	@GetMapping(value= "{id}")
	public Auteur_DTO getAuteurId(@PathVariable Long id) {
		final Auteur_Entity entities = auteurBO.findOne(id);
		
		return Auteur_Mapper.map(entities);
	}
}
