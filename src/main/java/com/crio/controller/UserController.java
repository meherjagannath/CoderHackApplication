package com.crio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crio.dto.UserDTO;
import com.crio.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/allUsers")
	//http://localhost:8070/users/allUsers
	public List<UserDTO> getAllUsers() {
		return userService.getAllUsers();

	}

	@GetMapping("/ByUserId")
	//http://localhost:8070/users/ByUserId/{userId}
	public UserDTO getUserById(@PathVariable Integer userId) {
		return userService.getUserById(userId);
	}

	@PostMapping("/newUser")
	//http://localhost:8070/users/newUser
	public UserDTO registerUser(@RequestBody UserDTO userDTO) {
		return userService.registerUser(userDTO);

	}

	@PutMapping("/{userId}")
	//http://localhost:8070/users/{userId}
	public UserDTO updateUserScore(@PathVariable Integer userId, @RequestParam int score) {
		return userService.updateUserScore(userId, score);
	}

	@DeleteMapping("/deleteByUserId")
	//http://localhost:8070/users/deleteByUserId/{userId}
	public UserDTO deregisterUser(@PathVariable Integer userId) {
		return userService.deregisterUser(userId);
	}

}
