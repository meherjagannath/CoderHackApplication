package com.crio.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.crio.controller.UserController;
import com.crio.dto.UserDTO;
import com.crio.service.UserService;

@SpringBootTest
class UserControllerTest {

	@Mock
	private UserService userService;

	@InjectMocks
	private UserController userController;

	@Test
	void testGetAllUsers() {
		// Prepare mock data
		List<UserDTO> mockUsers = new ArrayList<>();
		UserDTO user1 = new UserDTO();
		user1.setUserName("John");
		user1.setScore(80);
		mockUsers.add(user1);

		UserDTO user2 = new UserDTO();
		user2.setUserName("Alice");
		user2.setScore(70);
		mockUsers.add(user2);

		UserDTO user3 = new UserDTO();
		user3.setUserName("Bob");
		user3.setScore(90);
		mockUsers.add(user3);

		when(userService.getAllUsers()).thenReturn(mockUsers);

		List<UserDTO> actualUsers = userController.getAllUsers();

		assertEquals(mockUsers.size(), actualUsers.size());
		for (int i = 0; i < mockUsers.size(); i++) {
			assertEquals(mockUsers.get(i).getUserName(), actualUsers.get(i).getUserName());
			assertEquals(mockUsers.get(i).getScore(), actualUsers.get(i).getScore());
		}
	}

}
