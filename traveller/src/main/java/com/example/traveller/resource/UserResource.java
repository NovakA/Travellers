package com.example.traveller.resource;

import com.example.traveller.dto.UserDto;
import com.example.traveller.entity.User;
import com.example.traveller.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class UserResource {

	@Autowired
	private UserService userService;

	@ApiOperation(value = "User registration")
	@RequestMapping(value = "/user/registration", method = RequestMethod.POST)
	public ResponseEntity<User> registerUser(@RequestBody @Valid UserDto userDto) {

		final User user = userService.registerNewUserAccount(userDto);

		return new ResponseEntity<>(user, HttpStatus.OK);
	}
}
