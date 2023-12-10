package com.hexaware.hospitalmanagementsystem.repository;

import java.util.Optional;

/*
 * author:Madhuri&Sireesha,
 * lastmodified:14/11/23,
 * Description:Repository For Doctor
 * 
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hexaware.hospitalmanagementsystem.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
//	Optional<Doctor> findByuserName(String userName);
	public Doctor findByUserNameAndPassword(String userName, String password);
	 Optional<Doctor> findByUserName(String userName);
}
