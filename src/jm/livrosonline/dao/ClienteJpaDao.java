package jm.livrosonline.dao;

import javax.persistence.EntityManager;

import jm.livrosonline.entidade.Cliente;
import jm.livrosonline.factory.FactoryDao;

public class ClienteJpaDao implements ClienteDao {

	@Override
	public void criar(Cliente cliente) {
		EntityManager em = FactoryDao.createEntityManager();
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
	}

}
