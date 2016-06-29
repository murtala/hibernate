package com.thecafetechno.organisation;

import java.util.Set;

public class Employee {
	int employeeId;
	String employeeName;
	Set<String> contactNumbers;

	public Set<String> getContactNumbers() {
		return contactNumbers;
	}

	public void setContactNumbers(Set<String> contactNumbers) {
		this.contactNumbers = contactNumbers;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

}
