package com.hexaware.hospitalmanagementsystem.config;

/*
 * author:Madhuri&Sireesha,
 * lastmodified:19/11/23,
 * Description:class for DoctorInfoUserDetails
 * 
*/ 

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.hexaware.hospitalmanagementsystem.entity.Doctor;

public class DoctorInfoUserDetails implements UserDetails{

	private String name;
    private String password;
    private List<GrantedAuthority> authorities;

    public DoctorInfoUserDetails(Doctor doctorInfo) {
        name=doctorInfo.getUserName();
        password=doctorInfo.getPassword();
        authorities= Arrays.stream(doctorInfo.getRoles().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
	
	
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword()
	{
		return password;
	}

	@Override
	public String getUsername() {

		return name;
	}

	@Override
	public boolean isAccountNonExpired() {

		return true;
	}

	@Override
	public boolean isAccountNonLocked() {

		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
	public boolean isEnabled() {

		return true;
	}
	

}
