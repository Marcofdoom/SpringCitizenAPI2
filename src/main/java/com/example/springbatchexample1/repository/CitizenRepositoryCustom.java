package com.example.springbatchexample1.repository;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.springbatchexample1.model.Citizen;

@Repository
public interface CitizenRepositoryCustom {

	public List<Citizen> findCitizens(Long citizenId, String forenames, String surname, String homeAddress,
			Date dateOfBirth, String placeOfBirth, String sex);
}