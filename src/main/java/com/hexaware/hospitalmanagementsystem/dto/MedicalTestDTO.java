package com.hexaware.hospitalmanagementsystem.dto;

import java.util.Objects;

/*
 * author:Madhuri&Sireesha,
 * lastmodified:14/11/23,
 * Description:DTO class for MedicalTest
 * 
 */

public class MedicalTestDTO {
	private int testId;
	private String testName;

	public MedicalTestDTO() {
		super();
	}

	public MedicalTestDTO(int testId, String testName) {
		super();
		this.testId = testId;
		this.testName = testName;
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

	@Override
	public String toString() {
		return "MedicalTestDTO [testId=" + testId + ", testName=" + testName + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(testId, testName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MedicalTestDTO other = (MedicalTestDTO) obj;
		return testId == other.testId && Objects.equals(testName, other.testName);
	}
	

}
