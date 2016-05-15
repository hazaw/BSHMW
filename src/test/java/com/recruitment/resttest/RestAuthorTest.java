package com.recruitment.resttest;

import static com.jayway.restassured.RestAssured.expect;

import org.junit.Assert;
import org.junit.Test;

public class RestAuthorTest {

	private final String PATH_API = "/BestRecruitmentHomework/rest";
	private final String PATH_GET_ALL_AUTHORS = PATH_API + "/authors";

	@Test
	public void getAllAuthorsTest() {
		String resp = expect().statusCode(200).get(PATH_GET_ALL_AUTHORS).asString();
		resp.split(",");
		Assert.assertEquals(13, resp.split(",").length);

	}

	@Test
	public void getNumberOfBooksInCategoryTest() {
		Integer resp = Integer.valueOf(expect().statusCode(200).get(PATH_GET_ALL_AUTHORS + "/2/Techniczne").asString());
		Assert.assertEquals(new Integer(2), resp);
	}
}
