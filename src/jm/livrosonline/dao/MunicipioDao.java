package jm.livrosonline.dao;

import java.util.List;

import jm.livrosonline.entidade.Municipio;
import jm.livrosonline.entidade.UnidadeFederativa;

public interface MunicipioDao {
	List<Municipio> findMunicipiosByUf(UnidadeFederativa unidadeFederativa);

	Municipio findById(Integer id);
}
