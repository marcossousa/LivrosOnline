package jm.livrosonline.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import jm.livrosonline.entidade.Categoria;
import jm.livrosonline.entidade.Livro;
import jm.livrosonline.factory.FactoryDao;

public class LivroJpaDao implements LivroDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Categoria> findAllCategoriasLivro() {
		EntityManager em = FactoryDao.createEntityManager();
		Query query = em.createQuery("SELECT categoria FROM Categoria categoria");
		return query.getResultList();
	}

	@Override
	public Livro findById(Integer id) {
		EntityManager em = FactoryDao.createEntityManager();
		Query query = em.createQuery("SELECT livro " +
				"FROM Livro as livro WHERE livro.id = :id");
		query.setParameter("id", id);
		return (Livro) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Livro> getLivrosByCategoria(Categoria categoria) {
		StringBuilder hql = new StringBuilder("SELECT livro FROM Livro livro ");
		if (categoria != null) {
			hql.append("WHERE livro.categoria = :categoria ");
		}
		EntityManager em = FactoryDao.createEntityManager();
		Query query = em.createQuery(hql.toString());
		if (categoria != null) {
			query.setParameter("categoria", categoria);
		}
		return query.getResultList();
	}

}
