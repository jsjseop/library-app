package com.group.libraryapp.service.user;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.repository.user.UserJdbcRepository;

public class UserServiceV1 {

	private final UserJdbcRepository userRepository;

	public UserServiceV1(JdbcTemplate jdbcTemplate) {
		this.userRepository = new UserJdbcRepository(jdbcTemplate);
	}

	public void saveUser(UserCreateRequest request) {
		userRepository.saveUser(request.getName(), request.getAge());
	}

	public List<UserResponse> getUsers() {
		return userRepository.getUsers();
	}

	public void updateUser(UserUpdateRequest request) {
		if (userRepository.isUserNotExist(request.getId())) {
			throw new IllegalArgumentException();
		}
		userRepository.updateUser(request.getName(), request.getId());
	}

	public void deleteUser(String name) {
		if (userRepository.isUserNotExist(name)) {
			throw new IllegalArgumentException();
		}
		userRepository.deleteUser(name);
	}
}
