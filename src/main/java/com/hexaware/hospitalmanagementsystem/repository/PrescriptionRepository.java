package com.hexaware.hospitalmanagementsystem.repository;

/*
 * author:Madhuri&Sireesha,
 * lastmodified:14/11/23,
 * Description:Repository For Prescription
 * 
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.hospitalmanagementsystem.entity.Prescription;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Integer> {

}
