package jm.livrosonline.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import jm.livrosonline.entidade.UnidadeFederativa;
import jm.livrosonline.factory.FactoryDao;

public class UnidadeFederativaJpaDao implements UnidadeFederativaDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<UnidadeFederativa> findAll() {
		EntityManager em = FactoryDao.createEntityManager();
		Query query = em.createQuery("SELECT e FROM UnidadeFederativa AS e");
		return query.getResultList();
	}

	@Override
	public UnidadeFederativa findById(Integer id) {
		EntityManager em = FactoryDao.createEntityManager();
		Query query = em.createQuery("SELECT new UnidadeFederativa(e.id, e.descricao) " +
				"FROM UnidadeFederativa AS e WHERE e.id = :id");
		query.setParameter("id", id);
		return (UnidadeFederativa) query.getSingleResult();
	}
}
