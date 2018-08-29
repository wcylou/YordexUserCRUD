package com.yordex.entities;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTests {

	private static EntityManagerFactory emf;
	private static EntityManager em;
	
	@BeforeAll
	public static void setUpAll() throws Exception {
		emf = Persistence.createEntityManagerFactory("yordex");
	}

	@AfterAll
	public static void tearDownAll() throws Exception {
		emf.close();
	}

	@BeforeEach
	public void setUp() throws Exception {
		em = emf.createEntityManager();
	}

	@AfterEach
	public void tearDown() throws Exception {
		em.close();
	}

	@Test
	@DisplayName("Test User Mappings to Database")
	void test_user_mappings() {
		User u = em.find(User.class, 1);
		assertEquals("Bob", u.getFirstName());
	}

}