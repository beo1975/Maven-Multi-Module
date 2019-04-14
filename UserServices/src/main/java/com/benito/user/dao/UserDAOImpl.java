package com.benito.user.dao;

import java.util.HashMap;
import java.util.Map;

import com.benito.user.dto.User;

public class UserDAOImpl implements UserDAO {

	Map<Integer, User> users = new HashMap<>();

	@Override
	public void create(User user) {
		if (users.get(user.getId()) == null) {
			users.put(user.getId(), user);
		} else {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public User read(int id) {
		return users.get(id);
	}

	@Override
	public void update(User user) {
		if (users.get(user.getId()) != null) {
			users.put(user.getId(), user);
		} else {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public void delete(int id) {
		users.remove(id);
	}
}
