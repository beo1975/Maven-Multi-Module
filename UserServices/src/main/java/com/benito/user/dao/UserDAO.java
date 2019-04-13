package com.benito.user.dao;

import com.benito.user.dto.User;

public interface UserDAO {

	void create(User user);

	User read(int id);

	void update(User user);

	void delete(int id);
}
