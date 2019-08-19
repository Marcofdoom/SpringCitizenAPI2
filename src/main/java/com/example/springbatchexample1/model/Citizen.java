package com.example.springbatchexample1.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
public class Citizen {

	@Id
	private Long citizenId;

	private String forenames;

	private String surname;

	private String homeAddress;

	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	private String placeOfBirth;

	private String sex;

	public Citizen() {

	}

	public Citizen(Long citizenId, String forenames, String surname, String homeAddress, Date dateOfBirth,
			String placeOfBirth, String sex) {
		this.citizenId = citizenId;
		this.forenames = forenames;
		this.surname = surname;
		this.homeAddress = homeAddress;
		this.dateOfBirth = dateOfBirth;
		this.placeOfBirth = placeOfBirth;
		this.sex = sex;
	}
}