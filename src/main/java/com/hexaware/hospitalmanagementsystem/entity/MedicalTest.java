package com.hexaware.hospitalmanagementsystem.entity;

/*
 * author:Madhuri&Sireesha,
 * lastmodified:14/11/23,
 * Description:Entity class for MedicalTest
 * 
 */

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "medicaltest_details")
public class MedicalTest {
	@Id
	private int testId;
	@NotBlank(message = "Testname cannot be blank")
	@Pattern(regexp = "[A-Z][a-z]{3,15}")
	private String testName;

	@ManyToMany

	@JoinTable(name = "medicaltest_prescription", joinColumns = @JoinColumn(name = "testId"), inverseJoinColumns = @JoinColumn(name = "prescriptionId"))

	private Set<Prescription> prescriptionSet = new HashSet<>();

	public MedicalTest() {
		super();
	}

	public MedicalTest(int testId, @Pattern(regexp = "[A-Z][a-z]{3,15}") String testName,
			Set<Prescription> prescriptionSet) {
		super();
		this.testId = testId;
		this.testName = testName;
		this.prescriptionSet = prescriptionSet;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public Set<Prescription> getPrescriptionSet() {
		return prescriptionSet;
	}

	public void setPrescriptionSet(Set<Prescription> prescriptionSet) {
		this.prescriptionSet = prescriptionSet;
	}

	public MedicalTest(int testId, @Pattern(regexp = "[A-Z][a-z]{3,15}") String testName) {
		super();
		this.testId = testId;
		this.testName = testName;
	}

	

}
