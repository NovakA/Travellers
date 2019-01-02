package com.example.traveller.resource;

import com.example.traveller.dto.UserDto;
import com.example.traveller.entity.User;
import com.example.traveller.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {

	@Autowired
	private UserService userService;

	@ApiOperation(value = "User registration")
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ResponseEntity<User> createUser(@RequestBody @Valid UserDto userDto) {
		User user = userService.registerNewUserAccount(userDto);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@ApiOperation(value = "Get users")
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<User> getUsers() {
		return userService.findAll();
	}
}
