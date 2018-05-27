package com.bpi.controller;

import com.bpi.dao.UserDao;
import com.bpi.model.Oauth;
import com.bpi.model.UserDto;
import com.bpi.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/user", method = RequestMethod.GET)
    public List<Oauth> listUser(){
        return userService.findAll();
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public Oauth getOne(@PathVariable(value = "id") Long id){
        return userService.findById(id);
    }
    
    @RequestMapping(value="/signup", method = RequestMethod.POST)
    public Oauth saveUser(@RequestBody UserDto user){
    	return userService.save(user);
    }    
        

}
