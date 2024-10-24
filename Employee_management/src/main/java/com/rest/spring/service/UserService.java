package com.rest.spring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.spring.entity.Users;
import com.rest.spring.repository.UsersRepo;
import com.rest.spring.requests.LoginRequest;
@Service
public class UserService {
	 @Autowired
	    UsersRepo usersRepo;

	    public Users addUser(Users user) {

	        return usersRepo.save(user);

	    }

	    public Boolean loginUser(LoginRequest loginRequest) {

	        Optional<Users> user = usersRepo.findById(loginRequest.getUserId());
	        Users user1 = user.get();

	        if(user1 == null) {
	            return false;
	        }



	        if(!user1.getPassword().equals(loginRequest.getPassword())) {
	            return false;
	        }

	        return true;



	    }
}
