package com.univlittoral.projetback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univlittoral.projetback.entity.Auteur_Entity;
import com.univlittoral.projetback.repository.Auteur_Repository;

@Service
public class Auteur_Service {
	@Autowired
	private Auteur_Repository repo;
	
	public List<Auteur_Entity> findAll() {
		return repo.findAllbAuteurs();
	}
	
	
	public Auteur_Entity findOne(Long id) {
		return repo.getById(id);
	}
	
	
	public Auteur_Entity saveOne(Auteur_Entity auteurdo) {
		return repo.save(auteurdo);
	}
	
	public void deleteOne(Long id) {
		repo.deleteById(id);
	}
}
