package com.hexaware.hospitalmanagementsystem.repository;

import java.util.Optional;

/*
 * author:Madhuri&Sireesha,
 * lastmodified:14/11/23,
 * Description:Repository For admin
 * 
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.hospitalmanagementsystem.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    public Admin findByfullName(String fullName);
	public Admin findByUserNameAndPassword(String userName, String password);
	 Optional<Admin> findByUserName(String userName);
}
