package com.univlittoral.projetback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.univlittoral.projetback.entity.Livre_Entity;
import com.univlittoral.projetback.repository.*;


@Service
public class Livre_Service {
	@Autowired
	private Livre_Repository repo;
	
	public List<Livre_Entity> findAll() {
		return repo.findAllbLivres();
	}
	
	
	public Livre_Entity findOne(Long id) {
		return repo.getById(id);
	}
	
	
	public Livre_Entity saveOne(Livre_Entity livredo) {
		return repo.save(livredo);
	}
	
	public void deleteOne(Long id) {
		repo.deleteById(id);
	}
	
	public List<Livre_Entity> findByParam(String param) {
		return repo.findAllbyGenre(param);
	}
}

