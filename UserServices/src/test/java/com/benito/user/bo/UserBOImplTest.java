package com.benito.user.bo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

import com.benito.user.dao.UserDAO;
import com.benito.user.dao.UserDAOImpl;
import com.benito.user.dto.User;

class UserBOImplTest {

	@Test
	void testCreate() {
		User user = new User(1, "John Doe");
		UserBOImpl bo = new UserBOImpl();
		bo.create(user);
		UserDAO dao = bo.getDao();
		assertThat(dao).isNotNull();
	}

	@Test
	void testFindUser() {
		User user = new User(1, "John Doe");
		UserBOImpl bo = new UserBOImpl();
		bo.create(user);
		assertThat(bo.findUser(1).getName()).endsWith("Doe");
	}

	@Test
	void testDaoGettersSetters() {
		User user = new User(1, "John Doe");
		UserBOImpl bo = new UserBOImpl();
		bo.create(user);

		user = new User(2, "G.I. Joe");
		UserDAO dao = new UserDAOImpl();
		dao.create(user);
		bo.setDao(dao);

		assertAll(() -> {
			assertThat(dao.read(1)).isNull();
			assertThat(dao.read(2)).isNotNull();
		});
	}
}
