package com.univlittoral.projetback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.univlittoral.projetback.entity.Auteur_Entity;

public interface Auteur_Repository extends JpaRepository<Auteur_Entity, Long>{
	@Query(value="SELECT * FROM auteurs order by prenom ASC", nativeQuery=true)
	public List<Auteur_Entity> findAllbAuteurs();
}
