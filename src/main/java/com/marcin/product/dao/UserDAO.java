package com.marcin.product.dao;

import java.util.List;

import com.marcin.product.entity.User;

public interface UserDAO {

	public List<User> listUsers();
	public void addUser(User theUser);
}
