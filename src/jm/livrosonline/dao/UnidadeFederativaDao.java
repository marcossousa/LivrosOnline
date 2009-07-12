package jm.livrosonline.dao;

import java.util.List;

import jm.livrosonline.entidade.UnidadeFederativa;

public interface UnidadeFederativaDao {
	
	List<UnidadeFederativa> findAll();

	UnidadeFederativa findById(Integer id);

}
