package com.recruitment.dao;

import com.recruitment.model.Kategoria;

public interface KategoriaDao extends BaseDao<Kategoria, Long> {

	public Kategoria getKategoriaByName(String name);
}
