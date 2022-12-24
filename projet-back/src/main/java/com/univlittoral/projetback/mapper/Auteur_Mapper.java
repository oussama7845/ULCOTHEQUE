package com.univlittoral.projetback.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.univlittoral.projetback.dto.Auteur_DTO;
import com.univlittoral.projetback.entity.Auteur_Entity;

@Component
public class Auteur_Mapper {
	public final static Auteur_DTO map(final Auteur_Entity source) {
        final Auteur_DTO auteurdto = new Auteur_DTO();
        if (null == source) {
            return auteurdto;
        }
        auteurdto.setId(source.getId());
        auteurdto.setNom(source.getNom());
        auteurdto.setPrenom(source.getPrenom());
        auteurdto.setDateNaissance(source.getDateNaissance());
        
        
        return auteurdto;
    }
    
    public final static List<Auteur_DTO> map(final List<Auteur_Entity> source){
        List<Auteur_DTO> listAuteurDTO = new ArrayList<Auteur_DTO>();
        
        for (Auteur_Entity auteurDO :source) {
            listAuteurDTO.add(map(auteurDO));
        }
        return listAuteurDTO;
    }
    
    public final static Auteur_Entity map(final Auteur_DTO source) {
    	final  Auteur_Entity auteurdo = new Auteur_Entity();
    	if (null == source) {
            return auteurdo;
        }
        
    	auteurdo.setId(source.getId());
    	auteurdo.setNom(source.getNom());
    	auteurdo.setPrenom(source.getPrenom());
    	auteurdo.setDateNaissance(source.getDateNaissance());
        return auteurdo;
    }
}
