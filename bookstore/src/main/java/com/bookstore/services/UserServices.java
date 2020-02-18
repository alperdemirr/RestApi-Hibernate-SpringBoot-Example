package com.bookstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.entity.User;
import com.bookstore.repository.UserRepository;

import java.util.List;

import javax.transaction.Transactional;

@Service
public class UserServices {

	@Autowired
	private UserRepository userRepository;
	@Transactional
	public List<User> listAll(){
		return userRepository.findAll();
	}
	@Transactional
	public User findByUserName(String userName,String password){
		return userRepository.findUserByUserName(userName, password);
	}
	@Transactional
	public User findById(int Id){
		return userRepository.findById(Id);
	}
	@Transactional
	public int saveUser(User user){
		return userRepository.saveUser(user);
	}
	@Transactional
	public int deleteUser(int id){
		return userRepository.deleteUser(id);
	}
}
