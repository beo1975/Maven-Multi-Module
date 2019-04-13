package com.benito.user.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.benito.user.dto.User;

class UserDAOTest {

	@Test
	void testNewUserDAO() {
		UserDAO dao = new UserDAOImpl();

		dao.create(new User(1, "John Doe"));

		assertNotNull(dao);
	}

	@Test
	void testAddRepeatedUserDAO() {
		UserDAO dao = new UserDAOImpl();

		dao.create(new User(1, "John Doe"));

		assertThrows(IllegalArgumentException.class, ()-> dao.create(new User(1, "John Doe")));
	}
}
