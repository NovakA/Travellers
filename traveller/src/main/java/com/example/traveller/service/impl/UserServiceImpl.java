package com.example.traveller.service.impl;

import com.example.traveller.dto.UserDto;
import com.example.traveller.entity.User;
import com.example.traveller.repository.UserRepository;
import com.example.traveller.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Transactional
	@Override
	public User registerNewUserAccount(UserDto accountDto) {

		User user = new User();
		user.setFirstName(accountDto.getFirstName());
		user.setLastName(accountDto.getLastName());
		user.setPassword(accountDto.getPassword());
		user.setEmail(accountDto.getEmail());
		//user.setRoles(Arrays.asList("ROLE_USER"));
		return repository.save(user);
	}
}
