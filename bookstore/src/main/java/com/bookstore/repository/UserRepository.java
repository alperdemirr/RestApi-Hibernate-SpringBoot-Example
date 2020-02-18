package com.bookstore.repository;



import java.util.List;

import com.bookstore.entity.User;

public interface UserRepository {

	List<User> findAll();
	User findUserByUserName(String userName,String password);
	int deleteUserById(int id);
	int saveUser(User user);
	User findById(int Id);
	int deleteUser(int id);
}
