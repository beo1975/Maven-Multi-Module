package com.benito.user.bo;

import com.benito.user.dao.UserDAO;
import com.benito.user.dao.UserDAOImpl;
import com.benito.user.dto.User;

public class UserBOImpl implements UserBO {

	private UserDAO dao = new UserDAOImpl();

	@Override
	public void create(User user) {
		dao.create(user);
	}

	@Override
	public User findUser(int id) {
		return dao.read(id);
	}

	public UserDAO getDao() {
		return dao;
	}
}
