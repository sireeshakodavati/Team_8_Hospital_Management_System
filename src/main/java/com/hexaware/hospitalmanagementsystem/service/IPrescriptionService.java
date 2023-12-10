package com.hexaware.hospitalmanagementsystem.service;

/*
 * author:Madhuri&Sireesha,
 * lastmodified:18/11/23,
 * Description:Interface for prescription
 * 
 */

import java.util.List;
import com.hexaware.hospitalmanagementsystem.dto.PrescriptionDTO;

public interface IPrescriptionService {

	public PrescriptionDTO addPrescription(PrescriptionDTO prescriptionDTO);

	public PrescriptionDTO updatePrescription(PrescriptionDTO prescriptionDTO);

	public void deletePrescription(int prescriptionId);

	public PrescriptionDTO getPrescriptionById(int prescriptionId);

	public List<PrescriptionDTO> getAllPrescription();
}
