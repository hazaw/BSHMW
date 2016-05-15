package com.recruitment.service;

import java.util.List;

import javax.ejb.Local;

@Local
public interface BestService {

	public List<String> getListOfAllAuthors();

	public Integer getListOfBooksInGivenCategory(Long id, String kategoria);
}
