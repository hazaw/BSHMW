package com.recruitment.dao;

import java.util.List;

/**
 * 
 * @author USER
 *
 * @param <E>
 *            Entity Type
 * @param <K>
 *            Main Key Type
 */
public interface BaseDao<E, K> {

	void create(E instance);

	void deleteById(K id);

	E findById(K id);

	E update(E entity);

	List<E> listAll(Integer startPosition, Integer maxResult);

	List<E> listAll();
}
