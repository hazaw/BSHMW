package com.recruitment.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.recruitment.model.Ksiazka;

import lombok.NoArgsConstructor;

/**
 * DAO for Ksiazka
 */
@NoArgsConstructor
public class KsiazkaDaoImpl implements KsiazkaDao {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Override
	public void create(Ksiazka entity) {
		em.persist(entity);
	}

	@Override
	public void deleteById(Long id) {
		Ksiazka entity = em.find(Ksiazka.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	@Override
	public Ksiazka findById(Long id) {
		return em.find(Ksiazka.class, id);
	}

	@Override
	public Ksiazka update(Ksiazka entity) {
		return em.merge(entity);
	}

	@Override
	public List<Ksiazka> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<Ksiazka> findAllQuery = em.createQuery(
				"SELECT DISTINCT k FROM Ksiazka k LEFT JOIN FETCH k.kategoria LEFT JOIN FETCH k.autorSet ORDER BY k.id",
				Ksiazka.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}

	@Override
	public List<Ksiazka> listAll() {
		return em.createQuery("SELECT c FROM Ksiazka c", Ksiazka.class).getResultList();

	}

}
