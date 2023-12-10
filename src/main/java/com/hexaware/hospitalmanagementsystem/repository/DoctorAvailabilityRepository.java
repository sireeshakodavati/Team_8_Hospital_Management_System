package com.hexaware.hospitalmanagementsystem.repository;

/*
 * author:Madhuri&Sireesha,
 * lastmodified:14/11/23,
 * Description:Repository For DoctorAvailability
 * 
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.hospitalmanagementsystem.entity.DoctorAvailability;

@Repository
public interface DoctorAvailabilityRepository extends JpaRepository<DoctorAvailability, Integer> {

}
