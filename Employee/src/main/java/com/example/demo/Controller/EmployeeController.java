package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.EmployeeDto;
import com.example.demo.Service.EmployeeService;

@RestController
@RequestMapping("employee")
public class EmployeeController {

	@Autowired
	private EmployeeService eservice;

	@GetMapping(value = "empGetId", produces = "application/json")
	public ResponseEntity<?> findByemployeeId(@RequestBody EmployeeDto dto) {
		ResponseEntity<?> output = eservice.findByemployeeId(dto);
		return output;
	}

}
