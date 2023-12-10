package com.hexaware.hospitalmanagementsystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.hexaware.hospitalmanagementsystem.filter.JwtAuthFilter;

/*
 * author:Madhuri&Sireesha,
 * lastmodified:19/11/23,
 * Description:class for SecurityConfig
 * 
*/ 



@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

	
	private JwtAuthFilter authFilter;
	
	@Autowired
	public SecurityConfig(JwtAuthFilter authFilter) {
		super();
		this.authFilter = authFilter;
	}
	@Bean
	@Primary
	public UserDetailsService userDetailsService() 
	{
		return new UserInfoUserDetailsService();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.cors().and()
		.authorizeHttpRequests()
            .requestMatchers(
						/*
						 * "/api/Admin/authenticate", "/api/Patient/authenticate",
						 * "/api/Doctor/authenticate",
						 */
            		"/api/admin/add",
            		"/api/doctor/add",
            		"/api/patient/add",
            		"/api/login/adminlogin",
                "/api/login/doctorlogin",
                "/api/login/patientlogin",
               
                "/v3/api-docs/**",
                "/swagger-ui/**",
                "/swagger-resources/**"
                ).permitAll()
                  .requestMatchers(
                		  "/api/patient/**",               		  
                		  "/api/doctor/**",
                		  "/api/appointment/**",
                		  "/api/prescription/**",
                		  "/api/admin/**",
                		  "/api/medicaltest/**",
                		  "/api/doctoravailability/**"
                		  ).authenticated()
                  .and()
                  .sessionManagement()
                      .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                  .and()
                  .authenticationProvider(authenticationProvider())
                  .addFilterBefore(authFilter,UsernamePasswordAuthenticationFilter.class);
		  return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService());
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {

		return config.getAuthenticationManager();

	}

}