package com.hexaware.hospitalmanagementsystem.dto;


/*
 * author:Madhuri&Sireesha,
 * lastmodified:14/11/23,
 * Description:DTO class for Prescription
 * 
*/

public class PrescriptionDTO {

	private int prescriptionId;
	private String medicineName;
	private double price;

	public PrescriptionDTO() {
		super();
	}

	public PrescriptionDTO(int prescriptionId, String medicineName, double price) {
		super();
		this.prescriptionId = prescriptionId;
		this.medicineName = medicineName;
		this.price = price;
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


}