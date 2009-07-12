package jm.livrosonline.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import jm.livrosonline.entidade.Municipio;
import jm.livrosonline.entidade.UnidadeFederativa;
import jm.livrosonline.factory.FactoryDao;

public class MunicipioJpaDao implements MunicipioDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Municipio> findMunicipiosByUf(UnidadeFederativa unidadeFederativa) {
		EntityManager em = FactoryDao.createEntityManager();
		Query query = em.createQuery("SELECT new Municipio(e.id, e.descricao) " +
				"FROM Municipio as e WHERE e.unidadeFederativa = :uf");
		query.setParameter("uf", unidadeFederativa);
		return query.getResultList();
	}

	@Override
	public Municipio findById(Integer id) {
		EntityManager em = FactoryDao.createEntityManager();
		Query query = em.createQuery("SELECT new Municipio(e.id, e.descricao) " +
				"FROM Municipio as e WHERE e.id = :id");
		query.setParameter("id", id);
		return (Municipio) query.getSingleResult();
	}

}
