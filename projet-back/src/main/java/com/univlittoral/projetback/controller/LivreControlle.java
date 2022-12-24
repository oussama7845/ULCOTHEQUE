package com.univlittoral.projetback.controller;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.univlittoral.projetback.dto.Livre_DTO;
import com.univlittoral.projetback.entity.Livre_Entity;
import com.univlittoral.projetback.mapper.Livre_Mapper;
import com.univlittoral.projetback.service.Livre_Service;

@RestController
@RequestMapping(value ="/rest/bd/livres")
@Transactional

public class LivreControlle {
	@Autowired 
	private Livre_Service livreBO;
	
	@GetMapping(value ="{id}")
	public Livre_DTO getLivreId(@PathVariable Long id) {
		final Livre_Entity entities = livreBO.findOne(id);
		
		return Livre_Mapper.map(entities);
	}
	
	
	@PostMapping	
	public Livre_DTO postLivre(@RequestBody Livre_DTO livredo) {
		Livre_Entity livredop = livreBO.saveOne(Livre_Mapper.map(livredo));
		return Livre_Mapper.map(livredop);
	}
	
	@PutMapping(value ="{id}")
	public Livre_DTO getLivreId(@PathVariable Long id, @RequestBody Livre_Entity livredo) {
		final Livre_Entity entities = livreBO.findOne(id);
		entities.setNom(livredo.getNom());
		entities.setNbPages(livredo.getNbPages());
		entities.setLieuParution(livredo.getLieuParution());
		entities.setId(livredo.getId());
		entities.setGenre(livredo.getGenre());
		entities.setEditeur(livredo.getEditeur());
		entities.setDateParution(livredo.getDateParution());
		entities.setAuteur(livredo.getAuteur());
		return Livre_Mapper.map(entities);
	
	}
	
    @DeleteMapping(value="{id}")
    public void deleteLivre(@PathVariable Long id) {
    	livreBO.deleteOne(id);
    }   
    
    @GetMapping
    public List<Livre_DTO> getLivreByGenre(@RequestParam("genre") String param){
	List<Livre_Entity> livreDo = livreBO.findByParam(param);
	List<Livre_DTO> livres = new ArrayList<Livre_DTO>();
	livres = new ArrayList<>(Livre_Mapper.map(livreDo));
	return livres;
    }
    
    
}
