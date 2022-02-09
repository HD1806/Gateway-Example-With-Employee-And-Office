package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.OfficeDto;
import com.example.demo.Model.Office;
import com.example.demo.Service.OfficeService;

@RestController
@RequestMapping("/office")
public class OfficeController {
	
	@Autowired
	private OfficeService oservice;
	
	
	@PostMapping(value = "/create",produces = "application/json")
	public ResponseEntity<?> create(@RequestBody OfficeDto dto){
		ResponseEntity<?> output=oservice.create(dto);
		return output;
	}
	
	@PostMapping(value = "/createemp")
	public ResponseEntity<?> createemp(@RequestBody OfficeDto dto){
		ResponseEntity<?> output=oservice.createemp(dto);
		return output;
	}
	
	@PutMapping(value = "/updateemp",produces = "application/json")
	public ResponseEntity<?> updateemp(@RequestBody OfficeDto dto){
		ResponseEntity<?> output=oservice.update(dto);
		return output;
	}
	
	@GetMapping(value = "/getAll",produces = "application/json")
	public List<Office> findAll(){
		List<Office> output=oservice.findAll();
		return output;
	}
	
	@GetMapping(value = "/getById",produces = "application/json")
	public ResponseEntity<?> findByofficeId(@RequestBody OfficeDto dto){
		ResponseEntity<?> output=oservice.findByofficeId(dto);
		return output;
	}
	
	@DeleteMapping(value = "/delete/{employeeId}",produces = "application/json")
	public String deleteByemployeeId(@PathVariable int employeeId){
		oservice.deleteByemployeeId(employeeId);
		return "success";
	}

}
