package com.hexaware.hospitalmanagementsystem.entity;

/*
 * author:Madhuri&Sireesha,
 * lastmodified:14/11/23,
 * Description:Entity class for Patient
 * 
 */

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "prescription_details")
public class Prescription {
	@Id
	private int prescriptionId;
	@NotBlank(message = "medicine cannot be blank")
	@Pattern(regexp = "[A-Z][a-z]{3,20}")
	private String medicineName;
	@Min(value = 100)
	@Max(value = 5000)
	private double price;
	@ManyToMany(mappedBy = "prescriptionSet")
	private Set<MedicalTest> medicalTestSet = new HashSet<>();

	public Prescription() {
		super();
	}

	public Prescription(int prescriptionId, @Pattern(regexp = "[A-Z][a-z]{3,20}") String medicineName,
			@Min(100) @Max(5000) double price, Set<MedicalTest> medicalTestSet) {
		super();
		this.prescriptionId = prescriptionId;
		this.medicineName = medicineName;
		this.price = price;
		this.medicalTestSet = medicalTestSet;
	}

	public int getPrescriptionId() {
		return prescriptionId;
	}

	public void setPrescriptionId(int prescriptionId) {
		this.prescriptionId = prescriptionId;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Set<MedicalTest> getMedicalTestSet() {
		return medicalTestSet;
	}

	public void setMedicalTestSet(Set<MedicalTest> medicalTestSet) {
		this.medicalTestSet = medicalTestSet;
	}
}