package com.recruitment.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.recruitment.service.BestService;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ManagedBean
@NoArgsConstructor
@Getter
@Setter
public class TableBean {

	@EJB(beanName = "BestServiceRestClient")
	private BestService bestServiceRestClient;

	private List<String> authors;
	private List<Integer> tech;
	private List<Integer> oby;
	private List<Integer> clas;
	private List<Integer> scifi;

	@PostConstruct
	public void init() {
		authors = bestServiceRestClient.getListOfAllAuthors();
		tech = new ArrayList<Integer>();
		for (int i = 1; i <= authors.size(); i++) {
			tech.add(bestServiceRestClient.getListOfBooksInGivenCategory(new Long(i), "Techniczne"));
		}
		oby = new ArrayList<Integer>();
		for (int i = 1; i <= authors.size(); i++) {
			oby.add(bestServiceRestClient.getListOfBooksInGivenCategory(new Long(i), "Obyczajowe"));
		}
		clas = new ArrayList<Integer>();
		for (int i = 1; i <= authors.size(); i++) {
			clas.add(bestServiceRestClient.getListOfBooksInGivenCategory(new Long(i), "Klasyka"));
		}
		scifi = new ArrayList<Integer>();
		for (int i = 1; i <= authors.size(); i++) {
			scifi.add(bestServiceRestClient.getListOfBooksInGivenCategory(new Long(i), "ScienceFiction"));
		}
	}

}
