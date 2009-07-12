package jm.livrosonline.factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jm.livrosonline.dao.ClienteDao;
import jm.livrosonline.dao.ClienteJpaDao;
import jm.livrosonline.dao.MunicipioDao;
import jm.livrosonline.dao.MunicipioJpaDao;
import jm.livrosonline.dao.UnidadeFederativaDao;
import jm.livrosonline.dao.UnidadeFederativaJpaDao;

public class FactoryDao {
	
	private static EntityManagerFactory factory;
	
	public static MunicipioDao getMunicipioDao() {
		return new MunicipioJpaDao();
	}
	
	public static UnidadeFederativaDao getUnidadeFederativaDao() {
		return new UnidadeFederativaJpaDao();
	}
	
	public static EntityManager createEntityManager() {
		return getEntityManagerFactory().createEntityManager();
	}
	
	private static EntityManagerFactory getEntityManagerFactory() {
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory("LivrosOnline");
		}
		
		return factory;
	}

	public static ClienteDao getClienteDao() {
		return new ClienteJpaDao();
	}

}
