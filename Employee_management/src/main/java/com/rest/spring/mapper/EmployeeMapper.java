package com.rest.spring.mapper;

import com.rest.spring.dto.EmployeeDto;
import com.rest.spring.entity.Employee;

public class EmployeeMapper {
	public static EmployeeDto mapToEmployeeDto(Employee employee) {
		return new EmployeeDto(
				employee.getId(),
				employee.getFirstName(),
				employee.getDepartment(),
				employee.getExperience(),
				employee.getAge(),
				employee.getGender(),
				employee.getSalary(),
				employee.getPhoneNo(),
				employee.getEmail()
				);				
	}
	public static Employee mapToEmployee(EmployeeDto employeeDto) {
		return new Employee(
				employeeDto.getId(),
				employeeDto.getFirstName(),
				employeeDto.getDepartment(),
				employeeDto.getExperience(),
				employeeDto.getAge(),
				employeeDto.getGender(),
				employeeDto.getSalary(),
				employeeDto.getPhoneNo(),
				employeeDto.getEmail()
				);
	}

}
