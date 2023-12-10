package com.hexaware.hospitalmanagementsystem.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.hexaware.hospitalmanagementsystem.dto.MedicalTestDTO;
import com.hexaware.hospitalmanagementsystem.entity.MedicalTest;
import com.hexaware.hospitalmanagementsystem.repository.MedicalTestRepository;
@SpringBootTest
class MedicalTestServiceImpTest {

	 @Mock
	 private PasswordEncoder passwordEncoder;

	 @Mock
	 private MedicalTestRepository medicaltestRepository;

	 @InjectMocks
	 private MedicalTestServiceImp medicaltestService;

	 @BeforeEach
	 void setUp() {
	      MockitoAnnotations.openMocks(this);
	 }

//	@Test
//	void testMedicalTestServiceImp() {
//		fail("Not yet implemented");
//	}

	@Test
	void testAddMedicalTest() {
		MedicalTestDTO medicaltestDto=new MedicalTestDTO(1,"Dolo");
		MedicalTest medicaltest=new MedicalTest();
		medicaltest.setTestId(medicaltestDto.getTestId());
		medicaltest.setTestName(medicaltestDto.getTestName());
		when(medicaltestRepository.save(any())).thenReturn(medicaltest);
		MedicalTestDTO result=medicaltestService.addMedicalTest(medicaltestDto);
		assertNotNull(result);
		assertEquals(medicaltest.getTestId(),result.getTestId());
		assertEquals(medicaltest.getTestName(),result.getTestName());
	}

	
	  @Test void testUpdateMedicalTest() { 
		  MedicalTestDTO medicatestDto=new MedicalTestDTO(1,"test");
		  MedicalTest medicaltest=new MedicalTest();
		  medicaltest.setTestId(medicatestDto.getTestId());
		  when(medicaltestRepository.save(any())).thenReturn(medicaltest);
		  MedicalTestDTO result=medicaltestService.updateMedicalTest(medicatestDto);
		  assertNotNull(result);
		  assertEquals(medicaltest.getTestId(),result.getTestId());
		  assertEquals(medicaltest.getTestName(),result.getTestName());
		  
	  }
	  
	  @Test void testDeleteMedicalTest() {
		  int medicalTestId=1;
		  medicaltestService.deleteMedicalTest(medicalTestId);
		  verify(medicaltestRepository,times(1)).deleteById(medicalTestId);
		  
	  }
	 
	 @Test void testGetMedicalTestById() {  }
	 
	 @Test void testGetAllMedicalTest() {
		 List<MedicalTest> test=Arrays.asList(new MedicalTest(),new MedicalTest());
		 when(medicaltestRepository.findAll()).thenReturn(test);
		 List<MedicalTestDTO> result=medicaltestService.getAllMedicalTest();
		 assertNotNull(result);
		 assertEquals(test.size(),result.size());
	 }
	 

}