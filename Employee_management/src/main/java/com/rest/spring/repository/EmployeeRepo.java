package com.rest.spring.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.spring.entity.Employee;


@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

}
