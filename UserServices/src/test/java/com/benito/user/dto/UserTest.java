package com.benito.user.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

class UserTest {

	@Test
	void testChangeUserData() {
		User user = new User(1, "John Doe");

		assertAll(() -> {
			assertThat(user.toString()).hasLineCount(5);
			assertThat(user.getId()).isEqualByComparingTo(1);
		});

		user.setName("Martin Lee Gore");
		assertThat(user.getName()).doesNotStartWith("J");
	}
}
