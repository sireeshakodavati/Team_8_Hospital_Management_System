package com.hexaware.hospitalmanagementsystem.service;

/*
 * author:Madhuri&Sireesha,
 * lastmodified:18/11/23,
 * Description:Serviceimplementation for medicaltest
 * 
 */
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.hospitalmanagementsystem.dto.MedicalTestDTO;
import com.hexaware.hospitalmanagementsystem.entity.MedicalTest;
import com.hexaware.hospitalmanagementsystem.repository.MedicalTestRepository;

@Service
public class MedicalTestServiceImp implements IMedicalTestService {
	Logger logger = LoggerFactory.getLogger(AdminServiceImp.class);
	private MedicalTestRepository repository;

	@Autowired
	public MedicalTestServiceImp(MedicalTestRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public MedicalTestDTO addMedicalTest(MedicalTestDTO medicalTestDTO) {
		logger.info("Adding MedicalTest details");
		MedicalTest medicalTest = new MedicalTest();
		medicalTest.setTestId(medicalTestDTO.getTestId());
		medicalTest.setTestName(medicalTestDTO.getTestName());

		MedicalTest savedMedicalTest = repository.save(medicalTest);

		return new MedicalTestDTO(savedMedicalTest.getTestId(), savedMedicalTest.getTestName());
	}

	@Override
	public MedicalTestDTO updateMedicalTest(MedicalTestDTO medicalTestDTO) {
		logger.info("Updating MedicalTest details");
		MedicalTest medicalTest = new MedicalTest();
		medicalTest.setTestId(medicalTestDTO.getTestId());
		medicalTest.setTestName(medicalTestDTO.getTestName());

		MedicalTest savedMedicalTest = repository.save(medicalTest);

		return new MedicalTestDTO(savedMedicalTest.getTestId(), savedMedicalTest.getTestName());
	}

	@Override
	public void deleteMedicalTest(int testId) {
		repository.deleteById(testId);
		logger.info("MedicalTest record deleted");
	}

	@Override
	public MedicalTestDTO getMedicalTestById(int testId) {
		MedicalTest medicaltest = repository.findById(testId).orElse(new MedicalTest());
		return new MedicalTestDTO(medicaltest.getTestId(), medicaltest.getTestName());
	}

	@Override
	public List<MedicalTestDTO> getAllMedicalTest() {
		List<MedicalTest> medicalTests = repository.findAll();
        return medicalTests.stream()
                .map(medicalTest -> new MedicalTestDTO(medicalTest.getTestId(), medicalTest.getTestName()))
                .collect(Collectors.toList());
	}

}
