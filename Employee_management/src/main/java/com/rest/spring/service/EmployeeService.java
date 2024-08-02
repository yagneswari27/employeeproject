package com.rest.spring.service;

import java.util.List;

import com.rest.spring.dto.EmployeeDto;

public interface EmployeeService {
	EmployeeDto createEmployee(EmployeeDto employeeDto);
	EmployeeDto getEmployeeById(int employeeId);
	List<EmployeeDto> getAllEmployees();
	EmployeeDto updateEmployee(int employeeId,EmployeeDto updateEmployee);
	void deleteEmployee(int employeeId);
}
