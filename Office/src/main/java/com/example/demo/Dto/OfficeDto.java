package com.example.demo.Dto;

import lombok.Data;

@Data
public class OfficeDto {
	
	private int officeId;
	private String officeName;
	private String branch;
	private String phoneNo;
	
	private int employeeId;
	private String employeeName;
	private String department;
	private String branchName;
	private String totalPackage;
	private String perMonth;
	private String takeHome;
	private String experience;

}
