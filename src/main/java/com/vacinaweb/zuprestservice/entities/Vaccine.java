package com.vacinaweb.zuprestservice.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vacinaweb.zuprestservice.enums.VaccineStatus;

@Entity
@Table(name = "tb_vaccine")
public class Vaccine implements Serializable{
	private static final long serialVersionUID = -2059933021999153117L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;
	
	private Integer vaccineStatus;
	
	private String patientName;
	
	private String patientEmail;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "patient_id")
	private User patient;
	
	public Vaccine() {
	}

	public Vaccine(String name, Long id, Instant moment, VaccineStatus vaccineStatus,User patient) {
		super();
		this.name = name;
		this.id = id;
		this.moment = moment;
		setVaccineStatus(vaccineStatus);
		this.patientName = patient.getName();
		this.patientEmail = patient.getEmail();
		this.patient = patient;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}
	
	public VaccineStatus getVaccineStatus() {
		return VaccineStatus.valueOf(vaccineStatus);
	}

	public void setVaccineStatus(VaccineStatus vaccineStatus) {
		if(vaccineStatus != null) {
		this.vaccineStatus = vaccineStatus.getCode();
		}
	}

	public User getPatient() {
		return patient;
	}

	public void setPatient(User patient) {
		this.patient = patient;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientEmail() {
		return patientEmail;
	}

	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vaccine other = (Vaccine) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
