package com.alethia.implementation;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alethia.model.UserBean;
import com.alethia.service.UserRepository;

@Service
public class UserServiceImpl{

	@Autowired
	UserRepository repository;
	
	public void addNewUser(UserBean userObj) throws SQLException,IOException{
		repository.save(userObj);
	}
}
