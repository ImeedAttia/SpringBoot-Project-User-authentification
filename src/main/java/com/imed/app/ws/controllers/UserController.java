package com.imed.app.ws.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.imed.app.ws.Exceptions.UserExceptions;
import com.imed.app.ws.requests.UserRequest;
import com.imed.app.ws.responses.ErrorMessages;
import com.imed.app.ws.responses.UserResponses;
import com.imed.app.ws.services.UserService;
import com.imed.app.ws.shared.dto.UserDto;

@RestController
@RequestMapping("/users") 
public class UserController {
	
	@Autowired
	UserService userService;
	
	
	
	
	@GetMapping(path="/{id}",produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserResponses> getUser(@PathVariable String id) {
		
		UserDto userDto = userService.getUserByUserId(id);
		UserResponses userResponses = new UserResponses();
		BeanUtils.copyProperties(userDto, userResponses);
		return new ResponseEntity<UserResponses>(userResponses,HttpStatus.OK);	
	}
	
	@GetMapping(produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public List<UserResponses>getAllUsers(@RequestParam(value="page",defaultValue = "1") int page,@RequestParam(value="limit",defaultValue = "4") int limit) {		
		List<UserResponses> userResponse = new ArrayList<>();		
		List<UserDto> users =  userService.getUsers(page,limit);
		UserResponses user = new UserResponses();
			for (UserDto userDto : users) {
				BeanUtils.copyProperties(userDto, user);	
				userResponse.add(user);
			}
		return userResponse;
	}
	
	
	
	
	@PostMapping(consumes ={MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},
				 produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserResponses> createUser(@RequestBody UserRequest userRequest) throws Exception{
		
		if(userRequest.getFirstname().isEmpty()) throw new UserExceptions(ErrorMessages.MISSING_REQUIRED_FILED.getErrorMessage());
		
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userRequest, userDto);
		UserDto createUser = userService.createUser(userDto);
		UserResponses userResponse = new UserResponses();
		BeanUtils.copyProperties(createUser, userResponse);
		return new ResponseEntity<UserResponses>(userResponse,HttpStatus.CREATED);
	}
	
	
	
	
	@PutMapping(path="/{id}",consumes ={MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},
							 produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserResponses> updateUser(@PathVariable String id,@RequestBody UserRequest userRequest) {
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userRequest, userDto);
		UserDto updateUser = userService.updateUser(id,userDto);
		UserResponses userResponse = new UserResponses();
		BeanUtils.copyProperties(updateUser, userResponse);
		return new ResponseEntity<UserResponses>(userResponse,HttpStatus.ACCEPTED);
	}
	
	
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable String id) {
		userService.DeleteUser(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	

}
