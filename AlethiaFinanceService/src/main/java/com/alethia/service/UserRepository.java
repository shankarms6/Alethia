package com.alethia.service;

import org.springframework.data.repository.CrudRepository;

import com.alethia.model.UserBean;

public interface UserRepository extends CrudRepository<UserBean, Long>{

}
