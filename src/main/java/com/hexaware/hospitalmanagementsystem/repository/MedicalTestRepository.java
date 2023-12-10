package com.hexaware.hospitalmanagementsystem.repository;

/*
 * author:Madhuri&Sireesha,
 * lastmodified:14/11/23,
 * Description:Repository For MedicalTest
 * 
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.hospitalmanagementsystem.entity.MedicalTest;

@Repository
public interface MedicalTestRepository extends JpaRepository<MedicalTest, Integer> {

}