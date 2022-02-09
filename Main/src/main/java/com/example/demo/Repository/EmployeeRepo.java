package com.example.demo.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	@Transactional
	@Modifying
	@Query("delete from Employee where employeeId=:employeeId")
	void deleteByemployeeId(@Param("employeeId") int employeeId);

	Employee findByemployeeId(int employeeId);

}
