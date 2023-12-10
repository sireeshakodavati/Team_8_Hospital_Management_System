package com.hexaware.hospitalmanagementsystem.config;

import java.util.Arrays;

/*
 * author:Madhuri&Sireesha,
 * lastmodified:19/11/23,
 * Description:class for AdminInfoUserDetails
 * 
*/


import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.hexaware.hospitalmanagementsystem.entity.Admin;



public class AdminInfoUserDetails implements UserDetails 
{	
	//private static final long serialVersionUID = 1L;
	  private String name; 
	  private String password;
	    private List<GrantedAuthority> authorities;
	    public AdminInfoUserDetails(Admin adminInfo)
    	{
	    	  name = adminInfo.getUserName();
	           password = adminInfo.getPassword();
	           authorities =Arrays.stream(adminInfo.getRoles().split(","))
	                 .map(SimpleGrantedAuthority::new)
	                 .collect(Collectors.toList());
    	}
	    
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() 
	{

		return authorities;
	}

	@Override
	public String getPassword() {

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