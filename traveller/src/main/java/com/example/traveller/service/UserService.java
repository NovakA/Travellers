package com.example.traveller.service;

import com.example.traveller.dto.UserDto;
import com.example.traveller.entity.User;

public interface UserService {
	User registerNewUserAccount(UserDto accountDto);
}
