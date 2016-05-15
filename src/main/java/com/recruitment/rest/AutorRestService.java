package com.recruitment.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.recruitment.dao.AutorDaoImpl;
import com.recruitment.service.BestService;

/**
 * Rest class for Authors
 * 
 * @author USER
 *
 */
@Path("/authors")
@Stateless
public class AutorRestService {

	@Inject
	AutorDaoImpl autDao;

	@EJB(beanName = "BestServiceLocal")
	private BestService bestServiceLocal;

	/**
	 * Operates on GET request, returning a list of authors. Uses a method from
	 * AutorDao class - getAllAuthors.
	 * 
	 * @return list of authors
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public List getAuthorsList() {
		return bestServiceLocal.getListOfAllAuthors();

	}

	/**
	 * Operates on GET request, returning number of books in given category
	 * assigned to one author
	 * 
	 * @param id
	 *            - id of Autor
	 * @param category
	 *            - category of Book
	 * @return number of books in specified category
	 */
	@GET
	@Path("/{id}/{category}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getNumberOfBooksInCategory(@PathParam("id") Long id, @PathParam("category") String category) {

		Integer size = Integer.valueOf(bestServiceLocal.getListOfBooksInGivenCategory(id, category));
		return size.toString();

	}

}
