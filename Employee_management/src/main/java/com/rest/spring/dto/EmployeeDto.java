package com.rest.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
 private int id;
 private String firstName;
 private String department;
 private int experience;
 private int age;
 private String gender;
 private Long salary;
 private Long phoneNo;
 private String email;
}
