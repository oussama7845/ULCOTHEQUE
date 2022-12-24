package com.univlittoral.projetback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.univlittoral.projetback.entity.Livre_Entity;

public interface Livre_Repository extends JpaRepository<Livre_Entity, Long>{
	@Query(value="SELECT * FROM livres  WHERE genre = :param order by nom ASC", nativeQuery=true)
	public List<Livre_Entity> findAllbyGenre(@Param("param") String param);
	
	@Query(value="SELECT * FROM livres order by nom ASC", nativeQuery=true)
	public List<Livre_Entity> findAllbLivres();
	
}
