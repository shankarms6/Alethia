package com.alethia.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alethia.Exception.CustomServiceException;
import com.alethia.implementation.UserServiceImpl;
import com.alethia.model.UserBean;

@RestController
public class UserController {

	@Autowired
	UserServiceImpl userService;
	
	@PostMapping(value="/signUp")
	private void signupUser(@Valid @RequestBody UserBean userObj) throws SQLException,IOException, CustomServiceException {
		try {
			userService.addNewUser(userObj);
		} catch (Exception e)  {
			throw new CustomServiceException(e.getMessage());
		}
	}
}
