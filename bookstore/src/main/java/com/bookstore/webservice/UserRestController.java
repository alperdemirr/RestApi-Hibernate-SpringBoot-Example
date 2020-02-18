package com.bookstore.webservice;

import java.io.Console;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bookstore.entity.User;
import com.bookstore.services.UserServices;

@RestController
@RequestMapping("/rest")
public class UserRestController {

	@Autowired
	private UserServices services;
	
	@RequestMapping(method=RequestMethod.GET,value="/users")
	public ResponseEntity<List<User>> getUsers(){
		try {
			List<User> user = services.listAll();
			return ResponseEntity.ok(user);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	@RequestMapping(method=RequestMethod.GET,value="/userId")
	public ResponseEntity<User> findUserById(@RequestParam("id") int id){
		try {
			User user = services.findById(id);
			return ResponseEntity.ok(user);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	@RequestMapping(method=RequestMethod.GET,value="/user")
	public ResponseEntity<User> findUser(@RequestParam("userName") String userName, @RequestParam("password") String password){
		try {
			User user = services.findByUserName(userName, password);
			return ResponseEntity.ok(user);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	@RequestMapping(method=RequestMethod.POST,value="/user")
	public ResponseEntity<User> saveUser(@RequestBody User user){
		try {
			services.saveUser(user);
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		} catch (Exception e) {
			System.out.println("sorun :" + e.toString());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	@RequestMapping(method=RequestMethod.PUT,value="/user")
	public ResponseEntity<User> updateUser(@RequestBody User user){
		try {
			services.saveUser(user);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			System.out.println("hata1++"+e.toString());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/user/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable("id") int id){
		try {
			services.deleteUser(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			System.out.println("hata1++"+e.toString());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
