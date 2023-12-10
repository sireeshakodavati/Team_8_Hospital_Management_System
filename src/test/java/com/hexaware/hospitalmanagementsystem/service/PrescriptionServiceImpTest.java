package com.hexaware.hospitalmanagementsystem.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;
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

import com.hexaware.hospitalmanagementsystem.dto.PrescriptionDTO;
import com.hexaware.hospitalmanagementsystem.entity.Prescription;
import com.hexaware.hospitalmanagementsystem.repository.PrescriptionRepository;

@SpringBootTest
class PrescriptionServiceImpTest {

	
	@Mock
	 private PrescriptionRepository prescriptionRepository;
	 @InjectMocks
	 private PrescriptionServiceImp precsriptionService;
	 @BeforeEach
	 void setUp() {
	      MockitoAnnotations.openMocks(this);
	 }

	@Test
	void testAddPrescription() {
	   PrescriptionDTO prescriptionDTO = new PrescriptionDTO(1,"Dolo",700);
	 Prescription prescription=new Prescription();
        prescription.setPrescriptionId(prescriptionDTO.getPrescriptionId());  
        prescription.setMedicineName(prescriptionDTO.getMedicineName());             
        prescription.setPrice(prescriptionDTO.getPrice());
        when(prescriptionRepository.save(any())).thenReturn(prescription);

        PrescriptionDTO result = precsriptionService.addPrescription(prescriptionDTO);

        assertNotNull(result);
        assertEquals(prescription.getPrescriptionId(),prescription.getMedicineName(),prescription.getPrice(),result.getPrescriptionId(),result.getMedicineName(),result.getPrice());
	}

	private void assertEquals(int prescriptionId, String medicineName, double price, int prescriptionId2,
			String medicineName2, double price2) {
		// TODO Auto-generated method stub
		
	}
	@Test
	void testUpdatePrescription() {
		PrescriptionDTO prescriptionDTO = new PrescriptionDTO(1,"Dolo",700);
		 Prescription prescription=new Prescription();
	        prescription.setPrescriptionId(prescriptionDTO.getPrescriptionId());  
	        prescription.setMedicineName(prescriptionDTO.getMedicineName());             
	        prescription.setPrice(prescriptionDTO.getPrice());
	        when(prescriptionRepository.save(any())).thenReturn(prescription);

	        PrescriptionDTO result = precsriptionService.addPrescription(prescriptionDTO);

	        assertNotNull(result);
	        assertEquals(prescription.getPrescriptionId(),prescription.getMedicineName(),prescription.getPrice(),result.getPrescriptionId(),result.getMedicineName(),result.getPrice());
	}

	@Test
	void testDeletePrescription() {
		int prescriptionId=1;
		precsriptionService.deletePrescription(prescriptionId);
		verify(prescriptionRepository,times(1)).deleteById(prescriptionId);
	}

	
	@Test
	void testGetAllPrescription() {
		List<Prescription> p = Arrays.asList(new Prescription(), new Prescription());

        when(prescriptionRepository.findAll()).thenReturn(p);

        List<PrescriptionDTO> result = precsriptionService.getAllPrescription();

        assertNotNull(result);
        assertEquals(p.size(), null, result.size(), 0, null, 0);
	}
	}


