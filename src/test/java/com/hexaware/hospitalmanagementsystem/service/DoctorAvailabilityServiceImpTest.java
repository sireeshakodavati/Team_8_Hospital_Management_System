package com.hexaware.hospitalmanagementsystem.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.hexaware.hospitalmanagementsystem.dto.DoctorAvailabilityDTO;
import com.hexaware.hospitalmanagementsystem.entity.DoctorAvailability;
import com.hexaware.hospitalmanagementsystem.repository.DoctorAvailabilityRepository;

class DoctorAvailabilityServiceImpTest {
	
	
	 @Mock
	 private PasswordEncoder passwordEncoder;

	 @Mock
	 private DoctorAvailabilityRepository repository;

	 @InjectMocks
	 private DoctorAvailabilityServiceImp service;

	 @BeforeEach
	 void setUp() {
	      MockitoAnnotations.openMocks(this);
	 }

	/*
	 * @Test void testDoctorAvailabilityServiceImp() { fail("Not yet implemented");
	 * }
	 */

	@Test
	void testAddDoctorAvailability() {
		DoctorAvailabilityDTO doctoravailabilityDto=new DoctorAvailabilityDTO(1,"Saturday","2023-09-08 AM","2023-09-08 AM");
		DoctorAvailability avail=new DoctorAvailability();
		avail.setDoctorAvailabilityId(doctoravailabilityDto.getDoctorAvailabilityId());
		avail.setDayOfWeek(doctoravailabilityDto.getDayOfWeek());
		avail.setStartTime(doctoravailabilityDto.getStartTime());
		avail.setEndTime(doctoravailabilityDto.getEndTime());
		when(repository.save(any())).thenReturn(avail);
		DoctorAvailability result=service.addDoctorAvailability(doctoravailabilityDto);
		assertNotNull(result);
		assertEquals(avail.getDoctorAvailabilityId(),result.getDoctorAvailabilityId());
		assertEquals(avail.getDayOfWeek(),result.getDayOfWeek());
		assertEquals(avail.getStartTime(),result.getStartTime());
		assertEquals(avail.getEndTime(),result.getEndTime());
	}

	@Test
	void testUpdateDoctorAvailability() {
		DoctorAvailabilityDTO doctoravailabilityDto=new DoctorAvailabilityDTO(1,"Saturday","2023-09-08 AM","2023-09-08 AM");
		DoctorAvailability avail=new DoctorAvailability();
		avail.setDoctorAvailabilityId(doctoravailabilityDto.getDoctorAvailabilityId());
		avail.setDayOfWeek(doctoravailabilityDto.getDayOfWeek());
		avail.setStartTime(doctoravailabilityDto.getStartTime());
		avail.setEndTime(doctoravailabilityDto.getEndTime());
		when(repository.save(any())).thenReturn(avail);
		DoctorAvailability result=service.addDoctorAvailability(doctoravailabilityDto);
		assertNotNull(result);
		assertEquals(avail.getDoctorAvailabilityId(),result.getDoctorAvailabilityId());
		assertEquals(avail.getDayOfWeek(),result.getDayOfWeek());
		assertEquals(avail.getStartTime(),result.getStartTime());
		assertEquals(avail.getEndTime(),result.getEndTime());
		
	}

	@Test
	void testGetDoctorAvailabilityById() {
		
	}

	@Test
	void testDeleteDoctorAvailabilityById() {
		int doctoravailabilityId=1;
		service.deleteDoctorAvailabilityById(doctoravailabilityId);
		verify(repository,times(1)).deleteById(doctoravailabilityId);
		
	}

	@Test
	void testGetAllDoctorAvailability() {
		List<DoctorAvailability> list=Arrays.asList(new DoctorAvailability(),new DoctorAvailability());
		when(repository.findAll()).thenReturn(list);
		List<DoctorAvailability> result=service.getAllDoctorAvailability();
		assertNotNull(result);
		assertEquals(list.size(),result.size());
		
	}

}