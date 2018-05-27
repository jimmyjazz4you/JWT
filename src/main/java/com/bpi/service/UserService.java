package com.bpi.service;

import com.bpi.dao.UserDao;
import com.bpi.model.Oauth;
import com.bpi.model.UserDto;

import java.util.List;

public interface UserService {

    Oauth save(Oauth user);
    List<Oauth> findAll();
    void delete(long id);
    Oauth findOne(String username);

    Oauth findById(Long id);
	Oauth save(UserDao user);
	Oauth save(UserDto user);
}
