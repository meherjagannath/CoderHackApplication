package com.crio.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crio.Repository.UserRepository;
import com.crio.dto.UserDTO;
import com.crio.model.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<UserDTO> getAllUsers() {
		List<User> users = userRepository.findAll();
		Collections.sort(users, new Comparator<User>() {
			@Override
			public int compare(User u1, User u2) {
				return Integer.compare(u2.getScore(), u1.getScore());
			}
		});

		List<UserDTO> userDTOs = new ArrayList<>();
		for (User user : users) {
			userDTOs.add(convertToDTO(user));

		}
		return userDTOs;
	}

	private UserDTO convertToDTO(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setUserName(user.getUserName());
		userDTO.setScore(user.getScore());
		return userDTO;
	}

	public UserDTO getUserById(Integer userId) {
		Optional<User> optionalUser = userRepository.findById(userId);
		if (!optionalUser.isPresent()) {
			throw new EntityNotFoundException("User Not found");
		}
		User user = optionalUser.get();
		return convertToDTO(user);
	}

	public UserDTO registerUser(UserDTO userDTO) {
		User user = new User();
		user.setUserName(userDTO.getUserName());
		user.setScore(userDTO.getScore());
		user.setBadges(new ArrayList<>());
		User savedUser = userRepository.save(user);
		return convertToDTO(savedUser);

	}

	public UserDTO updateUserScore(Integer userId, int score) {
		Optional<User> optionalUser = userRepository.findById(userId);
		if (!optionalUser.isPresent()) {
			throw new EntityNotFoundException("User not found");
		}
		User user = optionalUser.get();
		if (score < 0 || score > 100) {
			throw new IllegalArgumentException("Score must be between 0 and 100");
		}
		user.setScore(score);
		user.updatedBadges();
		User updatedUser = userRepository.save(user);

		return convertToDTO(updatedUser);
	}

	public UserDTO deregisterUser(Integer userId) {
		Optional<User> findById = userRepository.findById(userId);
		if (!findById.isPresent()) {
			throw new EntityNotFoundException("User not found");
		}
		User user = findById.get();
		userRepository.deleteById(userId);

		return convertToDTO(user);
	}
}
