package com.hexaware.hospitalmanagementsystem.service;

/*
 * author:Madhuri&Sireesha,
 * lastmodified:18/11/23,
 * Description:Serviceimplementation for prescription
 * 
 */

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hexaware.hospitalmanagementsystem.dto.PrescriptionDTO;
import com.hexaware.hospitalmanagementsystem.entity.Prescription;
import com.hexaware.hospitalmanagementsystem.repository.PrescriptionRepository;

@Service
public class PrescriptionServiceImp implements IPrescriptionService {
	Logger logger = LoggerFactory.getLogger(PrescriptionServiceImp.class);
	private PrescriptionRepository prescriptionRepository;

	public PrescriptionServiceImp(PrescriptionRepository prescriptionRepository) {
		super();
		this.prescriptionRepository = prescriptionRepository;
	}

	@Override
	public PrescriptionDTO addPrescription(PrescriptionDTO prescriptionDTO) {
		logger.info("Adding Prescription details");
		Prescription prescription = new Prescription();
		prescription.setPrescriptionId(prescriptionDTO.getPrescriptionId());
		prescription.setMedicineName(prescriptionDTO.getMedicineName());
		prescription.setPrice(prescriptionDTO.getPrice());
		Prescription prescription1 = prescriptionRepository.save(prescription);

		return new PrescriptionDTO(prescription1.getPrescriptionId(), prescription1.getMedicineName(),
				prescription1.getPrice());

	}

	@Override
	public PrescriptionDTO updatePrescription(PrescriptionDTO prescriptionDTO) {
	logger.info("Updating Prescription details");
	Prescription prescription = new Prescription();
	prescription.setPrescriptionId(prescriptionDTO.getPrescriptionId());
	prescription.setMedicineName(prescriptionDTO.getMedicineName());
		prescription.setPrice(prescriptionDTO.getPrice());
		Prescription prescription1 = prescriptionRepository.save(prescription);

		return new PrescriptionDTO(prescription1.getPrescriptionId(), prescription1.getMedicineName(),
				prescription1.getPrice());
}
	
	

	@Override
	public void deletePrescription(int prescriptionId) {
		prescriptionRepository.deleteById(prescriptionId);
		logger.info("Prescription record deleted");
	}

	@Override
	public PrescriptionDTO getPrescriptionById(int prescriptionId) {
		Prescription prescription = prescriptionRepository.findById(prescriptionId).orElse(new Prescription());
		return new PrescriptionDTO(prescription.getPrescriptionId(), prescription.getMedicineName(),
				prescription.getPrice());
	}

	@Override
	public List<PrescriptionDTO> getAllPrescription() {
		 List<Prescription> prescriptions = prescriptionRepository.findAll();
		return prescriptions.stream()
                .map(prescription -> new PrescriptionDTO(prescription.getPrescriptionId(),
                        prescription.getMedicineName(), prescription.getPrice()))
                .collect(Collectors.toList());
	}

}