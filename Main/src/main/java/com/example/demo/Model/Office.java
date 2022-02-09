package com.example.demo.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
public class Office {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int officeId;
	@NonNull
	private String officeName;
	@NonNull
	private String branch;
	@NonNull
	private String phoneNo;
	
	@OneToMany(targetEntity = Employee.class,mappedBy = "office",fetch = FetchType.LAZY)
	@JsonIgnoreProperties("office")
	private List<Employee> employee=new ArrayList<>();

}
