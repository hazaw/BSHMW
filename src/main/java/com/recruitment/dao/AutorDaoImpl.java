package com.recruitment.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.recruitment.model.Autor;

import lombok.NoArgsConstructor;

/**
 * DAO for Autor
 */
@NoArgsConstructor
public class AutorDaoImpl implements AutorDao {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Override
	public void create(Autor entity) {
		em.persist(entity);
	}

	@Override
	public void deleteById(Long id) {
		Autor entity = em.find(Autor.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	@Override
	public Autor findById(Long id) {
		return em.find(Autor.class, id);
	}

	@Override
	public Autor update(Autor entity) {
		return em.merge(entity);
	}

	/**
	 * 
	 * 
	 * @param startPosition
	 * @param maxResult
	 * @return
	 */
	@Override
	public List<Autor> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<Autor> findAllQuery = em
				.createQuery("SELECT DISTINCT a FROM Autor a LEFT JOIN FETCH a.ksiazkiSet ORDER BY a.id", Autor.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}

	/**
	 * listAll authors only
	 * 
	 * @return List of Authors
	 */
	@Override
	public List<Autor> listAll() {
		return em.createQuery("SELECT c FROM Autor c", Autor.class).getResultList();
	}

}
