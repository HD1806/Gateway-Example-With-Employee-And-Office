package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Office;

@Repository
public interface OfficeRepo extends JpaRepository<Office, Integer> {

	@Query("select u from Office u where u.officeId=:officeId")
	Office findByofficeId(@Param("officeId") int officeId);

	@Query("select u from Office u where u.officeId=:officeId")
	Office findByOfficeId(@Param("officeId")int officeId);

//	@Query(value = "select * from Office u where u.officeId =:officeId",nativeQuery=true)
//	Office findByOfficeId(@Param("officeId") int i);

}
