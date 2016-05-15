package com.recruitment.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.recruitment.dao.AutorDaoImpl;
import com.recruitment.dao.KategoriaDaoImpl;
import com.recruitment.model.Autor;
import com.recruitment.model.Kategoria;
import com.recruitment.model.Ksiazka;

@Stateless
@Local(BestService.class)
public class BestServiceLocal implements BestService {

	@Inject
	private AutorDaoImpl autorDaoImpl;

	@Inject
	private KategoriaDaoImpl kategoriaDaoImpl;

	public List<String> getListOfAllAuthors() {
		List<Autor> rawList = autorDaoImpl.listAll();

		List<String> stringifiedAutors = new ArrayList<>();

		for (Autor aut : rawList) {
			stringifiedAutors.add(aut.getNazwisko() + " " + aut.getImie().substring(0, 1));
		}
		return stringifiedAutors;
	}

	public Integer getListOfBooksInGivenCategory(Long id, String kategoria) {
		Kategoria currentKat = kategoriaDaoImpl.getKategoriaByName(kategoria);
		Autor currentAutor = autorDaoImpl.findById(id);
		List<Ksiazka> resultList = new ArrayList<Ksiazka>();

		for (Ksiazka ks : currentAutor.getKsiazkiSet()) {
			if (ks.getKategoria().equals(currentKat)) {
				resultList.add(ks);
			}
		}
		return resultList.size();
	}
}
