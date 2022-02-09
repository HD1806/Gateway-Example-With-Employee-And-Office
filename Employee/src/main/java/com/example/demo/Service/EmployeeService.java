package com.example.demo.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.EmployeeDto;

@Service
public interface EmployeeService {

	ResponseEntity<?> findByemployeeId(EmployeeDto dto);

}
