package com.example.demo.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.EmployeeDto;
import com.example.demo.Model.Employee;
import com.example.demo.Model.MessageResponse;
import com.example.demo.Model.Office;
import com.example.demo.Repository.EmployeeRepo;
import com.example.demo.Repository.OfficeRepo;
import com.example.demo.Service.EmployeeService;

@Service
public class EmployeeImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo erepo;

	@Autowired
	private OfficeRepo orepo;
	
	@Autowired
	Environment env;

	@Override
	public ResponseEntity<?> findByemployeeId(EmployeeDto dto) {
		try {
		Office get1 = orepo.findByofficeId(dto.getOfficeId());
		Employee get = erepo.findByemployeeId(dto.getEmployeeId());
		return ResponseEntity.ok(new MessageResponse("success", HttpStatus.OK.value(), get));
	}catch(Exception e) {
		return ResponseEntity
				.ok(new MessageResponse(env.getProperty("getError"), HttpStatus.BAD_REQUEST.value()));
		}
	}

}
