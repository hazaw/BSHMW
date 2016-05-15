package com.recruitment.cditest;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.recruitment.dao.AutorDaoImpl;
import com.recruitment.dao.KategoriaDaoImpl;
import com.recruitment.dao.KsiazkaDaoImpl;
import com.recruitment.model.Autor;

@RunWith(Arquillian.class)
public class CdiTest {

	@Deployment
	public static Archive<?> createDeploy() {
		return ShrinkWrap.create(WebArchive.class, "daoTest.war").addPackage(AutorDaoImpl.class.getPackage().getName())
				.addPackage(Autor.class.getPackage().getName()).addAsResource("META-INF/persistence.xml")
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
	}

	@Inject
	private KsiazkaDaoImpl ksiazkaDao;

	@Inject
	private KategoriaDaoImpl kategoriaDao;

	@Inject
	private AutorDaoImpl autorDao;

	@Test
	public void shouldInjectKsiazkaDao() {
		Assert.assertNotNull(ksiazkaDao.listAll());
	}

	@Test
	public void shouldInjectAutorDao() {
		Assert.assertNotNull(autorDao.listAll());
	}

	@Test
	public void shouldInjectKategoriaDao() {
		Assert.assertNotNull(kategoriaDao.listAll());
	}
}
