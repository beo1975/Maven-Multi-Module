package com.benito.user.bo;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import com.benito.user.dto.User;

class UserBOImplTest {

	@Test
	void testCreate() {
		User user = new User(1, "John Doe");
		UserBOImpl bo = new UserBOImpl();
		bo.create(user);
		assertThat(bo.getDao()).isNotNull();
	}

	@Test
	void testFindUser() {
		User user = new User(1, "John Doe");
		UserBOImpl bo = new UserBOImpl();
		bo.create(user);
		assertThat(bo.findUser(1).getName()).endsWith("Doe");
	}
}
