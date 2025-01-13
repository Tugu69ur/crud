package com.crud.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.crud.entity.User;
import com.crud.crud.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserService UserService;
	
	@PostMapping("/save")
	public User save(@RequestBody User user) {
		return UserService.saveUser(user);
	}
	
	@GetMapping("/findAll")
	public List<User> findAll() {
		return UserService.findAll();
	}
	
	@GetMapping("/findById")
	public User findById(@RequestParam int id) {
		return UserService.findById(id);
	}
	
	@PutMapping("/update") 
	public User update(@RequestBody User user) {
		return UserService.updateUser(user);
	}
	
	@DeleteMapping("/deleteById")
	public void delete(@RequestParam int id) {
		UserService.deleteUser(id);
	}
	
}