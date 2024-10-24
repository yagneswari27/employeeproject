package com.rest.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.spring.entity.Users;
@Repository
public interface UsersRepo extends JpaRepository<Users, String>  {

}
