package com.bookstore.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.entity.User;


@Controller
public class HomeController {

	private RestTemplate restTemplate;
	@RequestMapping("/")
	public String viewHomePage() {
		return "Index";
	}
	@GetMapping("/users")
	public ModelAndView viewUsers(ModelMap model) {
		final String uri = "http://localhost:8080/rest/users";
		restTemplate = new RestTemplate();
		User[] user = restTemplate.getForObject(uri, User[].class);
		ModelAndView mav = new ModelAndView();
		mav.addObject("users",user);
		mav.setViewName("ListUser");
		return mav;
	}
	@PostMapping("/user")
	public ModelAndView findUser(@RequestParam("userName") String userName,@RequestParam("password") String password) {
		ModelAndView mav = new ModelAndView();

		try {
			
			final String uri = "http://localhost:8080/rest/user?userName="+userName+"&password="+password;
			restTemplate = new RestTemplate();
			restTemplate.getForObject(uri, String.class);
			mav.setViewName("Index");

			return mav;
		} catch (Exception e) {
			mav.addObject("successMessage", "Kullanıcı Adı yada Şifre hatalı !!");
			mav.setViewName("Index");
			return mav;
		}
	}

	@ModelAttribute
	public User initUser() {
		return new User();
	}
	@GetMapping("/user/add")
	public String saveUser() {
		return "CreateUser";
	}
	@PostMapping("/user/add")
	public ModelAndView saveUser(@ModelAttribute User user){
		ModelAndView mav = new ModelAndView();
		restTemplate = new RestTemplate();

		mav.setViewName("CreateUser");
		if (user != null) {
			restTemplate.postForLocation("http://localhost:8080/rest/user", user);
		}

		return mav;
	}
	
	@GetMapping("/update")
	public ModelAndView updateUser(@RequestParam("id") int Id){
		ModelAndView mav = new ModelAndView();
		final String uri = "http://localhost:8080/rest/userId?id="+Id;
		restTemplate = new RestTemplate();
		User user = restTemplate.getForObject(uri, User.class);
		
		mav.setViewName("UpdateUser");
		mav.addObject("id",user.getId());
		mav.addObject("name",user.getName());
		mav.addObject("surname",user.getSurname());
		mav.addObject("username",user.getUsername());
		mav.addObject("password",user.getPassword());
		return mav;
	}
	
	@PostMapping("/update")
	public String updateUser(@ModelAttribute("user") User user) {
		restTemplate = new RestTemplate();
		restTemplate.put("http://localhost:8080/rest/user", user);
	
		return "redirect:/users";
	}
	@GetMapping("/delete")
	public ModelAndView deleteUser(@RequestParam("id") int id) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("DeleteUser");
		mav.addObject("id",id);
		return mav;
	}
	@PostMapping("/delete")
	public String confirmDeleteUser(@RequestParam("id") int id) {
		restTemplate = new RestTemplate();
		restTemplate.delete("http://localhost:8080/rest/user/"+id);
		return "redirect:/users";
	}
}
