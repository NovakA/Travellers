package com.example.traveller.service;

import com.example.traveller.dto.UserDto;
import com.example.traveller.entity.User;

import java.util.List;

public interface UserService {
	User registerNewUserAccount(UserDto userDto);
	List<User> findAll();
}
