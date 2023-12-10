package com.hexaware.hospitalmanagementsystem.repository;

import java.util.Optional;

/*
 * author:Madhuri&Sireesha,
 * lastmodified:14/11/23,
 * Description:Repository For Patient
 * 
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hexaware.hospitalmanagementsystem.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
//	Optional<Patient> findByuserName(String userName);
	public Patient findByUserNameAndPassword(String userName, String password);
	 Optional<Patient> findByUserName(String userName);
}
