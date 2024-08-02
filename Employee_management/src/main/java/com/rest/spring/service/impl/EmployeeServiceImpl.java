package com.rest.spring.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.rest.spring.dto.EmployeeDto;
import com.rest.spring.entity.Employee;
import com.rest.spring.exception.ResourceNotFoundException;
import com.rest.spring.mapper.EmployeeMapper;
import com.rest.spring.repository.EmployeeRepo;
import com.rest.spring.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeRepo employeeRepo;
	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		Employee employee=EmployeeMapper.mapToEmployee(employeeDto);
		Employee savedEmployee= employeeRepo.save(employee);
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
		
	}

	@Override
	public EmployeeDto getEmployeeById(int employeeId) {
		Employee employee=employeeRepo.findById(employeeId)
				.orElseThrow(()->new ResourceNotFoundException("Employee is not exit with given id:"+employeeId));
				return EmployeeMapper.mapToEmployeeDto(employee);
		
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		
		List <Employee> employees=employeeRepo.findAll();
		return employees.stream().map((employee)->EmployeeMapper.mapToEmployeeDto(employee))
				.collect(Collectors.toList());
	}

	@Override
	public EmployeeDto updateEmployee(int employeeId, EmployeeDto updateEmployee) {
		Employee employee=employeeRepo.findById(employeeId).orElseThrow(
				()->new ResourceNotFoundException("Employee is not exist with given id:"+employeeId));
	employee.setFirstName(updateEmployee.getFirstName());
	employee.setDepartment(updateEmployee.getDepartment());
	employee.setExperience(updateEmployee.getExperience());
	employee.setAge(updateEmployee.getAge());
	employee.setGender(updateEmployee.getGender());
	employee.setSalary(updateEmployee.getSalary());
	employee.setPhoneNo(updateEmployee.getPhoneNo());
	employee.setEmail(updateEmployee.getEmail());
	Employee updatedEmployeeObj=employeeRepo.save(employee);
		return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj) ;
		
	}

	@Override
	public void deleteEmployee(int employeeId) {
		Employee employee=employeeRepo.findById(employeeId).orElseThrow(
				()->new ResourceNotFoundException("Employee is not exist with given id:"+employeeId));
		employeeRepo.deleteById(employeeId);
		
	}
	
}
