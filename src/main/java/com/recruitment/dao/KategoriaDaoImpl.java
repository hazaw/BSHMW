package com.recruitment.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.recruitment.model.Kategoria;

import lombok.NoArgsConstructor;

/**
 * DAO for Kategoria
 */
@NoArgsConstructor
public class KategoriaDaoImpl implements KategoriaDao {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Override
	public void create(Kategoria entity) {
		em.persist(entity);
	}

	@Override
	public void deleteById(Long id) {
		Kategoria entity = em.find(Kategoria.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	@Override
	public Kategoria findById(Long id) {
		return em.find(Kategoria.class, id);
	}

	@Override
	public Kategoria update(Kategoria entity) {
		return em.merge(entity);
	}

	/**
	 * 
	 * @param startPosition
	 * @param maxResult
	 * @return
	 */
	@Override
	public List<Kategoria> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<Kategoria> findAllQuery = em.createQuery(
				"SELECT DISTINCT k FROM Kategoria k LEFT JOIN FETCH k.ksiazkiSet ORDER BY k.id", Kategoria.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}

	/**
	 * listAll Categories
	 * 
	 * @return List of categories
	 */
	@Override
	public List<Kategoria> listAll() {
		return em.createQuery("SELECT c FROM Kategoria c", Kategoria.class).getResultList();
	}

	/**
	 * Returns Kategoria based on its name
	 * 
	 * @param name
	 * @return
	 */
	@Override
	public Kategoria getKategoriaByName(String name) {
	
		Kategoria kat = null;
		
		try{
			kat = em.createQuery("SELECT c FROM Kategoria c WHERE c.nazwa =:name", Kategoria.class)
					.setParameter("name", name).getSingleResult();
		}
		catch(Exception e){
			System.err.println(e.getMessage());
		}
		return kat;
	}
	

}
