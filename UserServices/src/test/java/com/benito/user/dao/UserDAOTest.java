package com.benito.user.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
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

		assertThrows(IllegalArgumentException.class, () -> dao.create(new User(1, "John Doe")));
	}

	@Test
	void testRemoveUserDAO() {
		UserDAO dao = new UserDAOImpl();

		dao.create(new User(1, "John Doe"));

		assertThat(dao.read(1).getName()).isEqualTo("John Doe");

		dao.delete(1);

		assertThat(dao.read(1)).isNull();

	}

	@Test
	void testReadUserDAO() {
		User user = new User(1, "John Doe");
		user.setMail("john.doe@home.com");

		UserDAO dao = new UserDAOImpl();
		dao.create(user);

		assertAll(() -> {
			assertThat(dao.read(1).getName()).isEqualTo("John Doe");
			assertThat(dao.read(1).getId()).isGreaterThan(0);
			assertThat(dao.read(1).getMail()).contains("@");
		});
	}

	@Test
	void testUpdateUserDAO() {
		UserDAO dao = new UserDAOImpl();

		dao.create(new User(1, "John Doe"));

		assertDoesNotThrow(() -> dao.update(new User(1, "Jane Doe")));
		assertThat(dao.read(1).getName()).doesNotContain("John");
		assertThrows(IllegalArgumentException.class, () -> dao.update(new User(2, "John Doe")));
	}
}
