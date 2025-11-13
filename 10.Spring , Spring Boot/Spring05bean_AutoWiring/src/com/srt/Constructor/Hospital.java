package com.srt.Constructor;

public class Hospital {

	private Patient patient;

	private Doctor doctor;

	public Hospital(Patient patient, Doctor doctor1) {
		super();
		this.patient = patient;
		this.doctor = doctor1;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

}
