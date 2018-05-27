package com.bpi.service.impl;

import com.bpi.dao.UserDao;
import com.bpi.model.Oauth;
import com.bpi.model.UserDto;
import com.bpi.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {
	
	@Autowired
	private UserDao userDao;

	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Oauth user = userDao.findByUsername(username);
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority());
	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

	public List<Oauth> findAll() {
		List<Oauth> list = new ArrayList<>();
		userDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public void delete(long id) {
		userDao.delete(id);
	}

	@Override
	public Oauth findOne(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	public Oauth findById(Long id) {
		return userDao.findOne(id);
	}

	@Override
    public Oauth save(UserDto user) {
	    Oauth newUser = new Oauth();
	    newUser.setUsername(user.getUsername());
	    newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        return userDao.save(newUser);
    }

	@Override
	public Oauth save(Oauth user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Oauth save(UserDao user) {
		// TODO Auto-generated method stub
		return null;
	}
}