package com.recruitment.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

import org.jboss.resteasy.client.ClientRequest;

import com.recruitment.rest.RestRequestProducer;

@Stateless
@Local(BestService.class)
public class BestServiceRestClient implements BestService {
	@Inject
	RestRequestProducer prod;

	public List<String> getListOfAllAuthors() {

		List<String> list = new ArrayList<>();
		String str = null;
		ClientRequest request = RestRequestProducer
				.getClientRequest("http://localhost:8080/BestRecruitmentHomework/rest/authors/");
		try {
			str = request.get(String.class).getEntity();
			String[] stArr = str.split(",");
			for (String stri : stArr) {
				list.add(stri);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return list;

	}

	public Integer getListOfBooksInGivenCategory(Long id, String kategoria) {

		Integer answer = null;
		ClientRequest request = RestRequestProducer
				.getClientRequest("http://localhost:8080/BestRecruitmentHomework/rest/authors/" + id + "/" + kategoria);
		try {
			answer = request.get(Integer.class).getEntity();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return answer;

	}

}
