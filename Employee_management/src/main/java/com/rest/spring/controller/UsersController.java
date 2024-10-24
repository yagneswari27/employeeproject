package com.rest.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.spring.entity.Users;
import com.rest.spring.requests.LoginRequest;
import com.rest.spring.service.UserService;

@RestController
public class UsersController {
	@Autowired
    UserService userService;

    @PostMapping("/addUser")
    @CrossOrigin(origins = "http://localhost:3000")
    public Users addUser(@RequestBody Users user) {
        return userService.addUser(user);
    }

    @PostMapping("/loginUser")
    @CrossOrigin(origins = "http://localhost:3000")
    public Boolean loginUser(@RequestBody LoginRequest loginRequest) {
        return userService.loginUser(loginRequest);

    }

}
