package com.example.demo.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.OfficeDto;
import com.example.demo.Model.Office;

@Service
public interface OfficeService {

	ResponseEntity<?> create(OfficeDto dto);

	ResponseEntity<?> createemp(OfficeDto dto);

	ResponseEntity<?> update(OfficeDto dto);

	List<Office> findAll();

	ResponseEntity<?> findByofficeId(OfficeDto dto);

	String deleteByemployeeId(int employeeId);

}
