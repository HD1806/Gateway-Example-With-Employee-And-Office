package com.example.demo.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	
	@Id
	private int employeeId;
	@NonNull
	private String employeeName;
	@NonNull
	private String department;
	@NonNull
	private String branchName;
	@NonNull
	private String totalPackage;
	@NonNull
	private String perMonth;
	@NonNull
	private String takeHome;
	@NonNull
	private String experience;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="officeId", referencedColumnName = "officeId")
	@JsonIgnoreProperties("employee")
	private Office office;
	

}
