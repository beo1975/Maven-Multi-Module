package com.benito.user.bo;

import com.benito.user.dto.User;

public interface UserBO {

	public void create(User user);

	public User findUser(int id);
}
