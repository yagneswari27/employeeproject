package com.rest.spring.controller;

import java.util.List;



//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.spring.dto.EmployeeDto;
import com.rest.spring.service.EmployeeService;

import lombok.AllArgsConstructor;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {
	//@Autowired
	private EmployeeService employeeService;
	//Build Add Employee Rest API
	@PostMapping
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
	EmployeeDto savedEmployee=employeeService.createEmployee(employeeDto);
		return new ResponseEntity<>(savedEmployee,HttpStatus.CREATED) ;
	}
	//Build get Employee Rest API
	@GetMapping("{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") int employeeId ){
		EmployeeDto employeeDto=employeeService.getEmployeeById(employeeId);
		return ResponseEntity.ok(employeeDto) ;
	}
	//Build get all employee Rest  API
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
		List<EmployeeDto> employees=employeeService.getAllEmployees();
		return ResponseEntity.ok(employees);
	}
	//Build Update Employee API
	@PutMapping("{id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") int employeeId,@RequestBody EmployeeDto updateEmployee){
		EmployeeDto employeeDto=employeeService.updateEmployee(employeeId, updateEmployee);
		return ResponseEntity.ok(employeeDto);
	}
	//Build delete employee rest API
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") int employeeId){
		employeeService.deleteEmployee(employeeId);
		return ResponseEntity.ok("Employee deleted Successfully");
	}

}
