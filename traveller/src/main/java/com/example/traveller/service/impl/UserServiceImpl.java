package com.example.traveller.service.impl;

import com.example.traveller.dto.UserDto;
import com.example.traveller.entity.User;
import com.example.traveller.exception.EmailExistsException;
import com.example.traveller.repository.UserRepository;
import com.example.traveller.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Override
	public User registerNewUserAccount(UserDto accountDto) {

		User user = new User();
		user.setFirstName(accountDto.getFirstName());
		user.setLastName(accountDto.getLastName());
		user.setPassword(accountDto.getPassword());
		user.setEmail(accountDto.getEmail());
		return repository.save(user);
	}

	@Override
	public List<User> findAll() {
		return repository.findAll();
	}

	public void validateNotExistEmail(UserDto userDto) {
		User user = repository.findByEmail(userDto.getEmail());
		if (user != null) {
			throw new EmailExistsException("Email already exists!");
		}
	}
}
