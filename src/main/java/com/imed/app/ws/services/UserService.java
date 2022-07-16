package com.imed.app.ws.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.imed.app.ws.shared.dto.UserDto;

public interface UserService extends UserDetailsService {
	
	UserDto createUser(UserDto userDto);
	UserDto getUser(String email);
	UserDto getUserByUserId(String UserId);
	UserDto updateUser(String id,UserDto userDto);
	void DeleteUser(String UserId);
	List<UserDto> getUsers(int page,int limit,String search,int status);
}
