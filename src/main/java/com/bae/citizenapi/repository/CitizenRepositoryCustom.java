package com.bae.citizenapi.repository;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bae.citizenapi.model.Citizen;

@Repository
public interface CitizenRepositoryCustom {

	public List<Citizen> findCitizens(Long citizenId, String forenames, String surname, String homeAddress,
			Date dateOfBirth, String placeOfBirth, String sex);
}