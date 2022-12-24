package com.univlittoral.projetback.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.univlittoral.projetback.dto.Livre_DTO;
import com.univlittoral.projetback.entity.Livre_Entity;

@Component
public class Livre_Mapper {
	public final static Livre_DTO map(final Livre_Entity source) {
        final Livre_DTO livredto = new Livre_DTO();
        if (null == source) {
            return livredto;
        }
        livredto.setId(source.getId());
        livredto.setNom(source.getNom());
        livredto.setEditeur(source.getEditeur());
        livredto.setNbPages(source.getNbPages());
        livredto.setDateParution(source.getDateParution());
        livredto.setLieuParution(source.getLieuParution());
        livredto.setGenre(source.getGenre());
        livredto.setAuteur(Auteur_Mapper.map(source.getAuteur()));
        
        
        return livredto;
    }
    
    public final static List<Livre_DTO> map(List<Livre_Entity> source){
        List<Livre_DTO> listLivreDTO = new ArrayList<Livre_DTO>();
        for (Livre_Entity livreDO :source) {
            listLivreDTO.add(map(livreDO));
        }
        
        
        
        return listLivreDTO;
    }
    
    
    
    
    public final static Livre_Entity map(final Livre_DTO source) {
    	final  Livre_Entity livredo = new Livre_Entity();
    	if (null == source) {
            return livredo;
        }
    	livredo.setId(source.getId());
        livredo.setNom(source.getNom());
        livredo.setEditeur(source.getEditeur());
        livredo.setNbPages(source.getNbPages());
        livredo.setLieuParution(source.getLieuParution());
        livredo.setDateParution(source.getDateParution());
        livredo.setGenre(source.getGenre());
        livredo.setAuteur(Auteur_Mapper.map(source.getAuteur()));
        return livredo;
    }
}
