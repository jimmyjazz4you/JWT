package com.devglan.service;

import com.devglan.dao.UserDao;
import com.devglan.model.Oauth;
import com.devglan.model.UserDto;

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
