package com.watch.api.admin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.watch.dto.UserDTO;

@RestController(value="userAPIOfAdmin")
public class UserAPI {

	@PostMapping("/api/user")
	public UserDTO createType(@RequestBody UserDTO userDTO) {		
		return userDTO;
	}
}
