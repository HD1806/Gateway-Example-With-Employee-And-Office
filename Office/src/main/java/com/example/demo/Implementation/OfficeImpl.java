package com.example.demo.Implementation;

import org.springframework.core.env.Environment;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.OfficeDto;
import com.example.demo.Model.Employee;
import com.example.demo.Model.MessageResponse;
import com.example.demo.Model.Office;
import com.example.demo.Repository.EmployeeRepo;
import com.example.demo.Repository.OfficeRepo;
import com.example.demo.Service.OfficeService;

@Service
public class OfficeImpl implements OfficeService {

	@Autowired
	private OfficeRepo orepo;

	@Autowired
	private EmployeeRepo erepo;

	@Autowired
	Environment env;

	@Override
	public ResponseEntity<?> create(OfficeDto dto) {
		try {
			Employee ecreate = Employee.builder().employeeId(dto.getEmployeeId()).employeeName(dto.getEmployeeName())
					.department(dto.getDepartment()).branchName(dto.getBranchName()).experience(dto.getExperience())
					.totalPackage(dto.getTotalPackage()).perMonth(dto.getPerMonth()).takeHome(dto.getTakeHome())
					.build();

			Office create = Office.builder().officeId(dto.getOfficeId()).officeName(dto.getOfficeName())
					.branch(dto.getBranch()).phoneNo(dto.getPhoneNo()).build();

			create = orepo.save(create);
			ecreate.setOffice(create);

			erepo.save(ecreate);

			return ResponseEntity.ok(new MessageResponse("success", HttpStatus.OK.value(), create));
		} catch (Exception e) {
			return ResponseEntity
					.ok(new MessageResponse(env.getProperty("createError"), HttpStatus.BAD_REQUEST.value()));
		}

	}

	@Override
	public ResponseEntity<?> update(OfficeDto dto) {
		try {
			Office id = orepo.findByofficeId(dto.getOfficeId());
			Employee update = Employee.builder().employeeId(dto.getEmployeeId()).employeeName(dto.getEmployeeName())
					.department(dto.getDepartment()).branchName(dto.getBranchName()).experience(dto.getExperience())
					.totalPackage(dto.getTotalPackage()).perMonth(dto.getPerMonth()).takeHome(dto.getTakeHome())
					.build();
			update=erepo.save(update);
			update.setOffice(id);
			orepo.save(id);
			return ResponseEntity.ok(new MessageResponse("success", HttpStatus.OK.value(), id));
		} catch (Exception e) {
			return ResponseEntity
					.ok(new MessageResponse(env.getProperty("updateError"), HttpStatus.BAD_REQUEST.value()));
		}

	}

	@Override
	public List<Office> findAll() {
		return orepo.findAll();
	}

	@Override
	public ResponseEntity<?> findByofficeId(OfficeDto dto) {
		try {
			Office get = orepo.findByofficeId(dto.getOfficeId());
			return ResponseEntity.ok(new MessageResponse("success", HttpStatus.OK.value(), get));
		} catch (Exception e) {
			return ResponseEntity.ok(new MessageResponse(env.getProperty("getError"), HttpStatus.BAD_REQUEST.value()));
		}

	}

	@Override
	public ResponseEntity<?> createemp(OfficeDto dto) {
		try {
//			Office id = orepo.findByOfficeId(1);
			Office id = orepo.findByOfficeId(dto.getOfficeId());
			Employee ecreate = Employee.builder().employeeId(dto.getEmployeeId()).employeeName(dto.getEmployeeName())
					.department(dto.getDepartment()).branchName(dto.getBranchName()).experience(dto.getExperience())
					.totalPackage(dto.getTotalPackage()).perMonth(dto.getPerMonth()).takeHome(dto.getTakeHome())
					.build();
			ecreate=erepo.save(ecreate);
			ecreate.setOffice(id);
			id = orepo.save(id);
			//System.out.println(id);
			return ResponseEntity.ok(new MessageResponse("success",HttpStatus.OK.value(),ecreate));
		} catch (Exception e) {
			return ResponseEntity.ok(new MessageResponse(env.getProperty("createEmpError"),HttpStatus.BAD_REQUEST.value()));
		}
	}

	@Override
	@Transactional
	public String deleteByemployeeId(int employeeId) {
		erepo.deleteByemployeeId(employeeId);
		return "success";
	}

}
