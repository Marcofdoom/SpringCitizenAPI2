package com.bae.citizenapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bae.citizenapi.model.Citizen;
import com.bae.citizenapi.repository.CitizenRepository;

@Service
public class CitizenServiceImplementation implements CitizenService {

	private CitizenRepository citizenRepository;

	@Autowired
	public CitizenServiceImplementation(CitizenRepository citizenRepository) {
		this.citizenRepository = citizenRepository;
	}

	@Override
	public List<Citizen> getCitizens(Citizen citizen) {
		return citizenRepository.findCitizens(citizen.getCitizenId(), citizen.getForenames(), citizen.getSurname(),
				citizen.getHomeAddress(), citizen.getDateOfBirth(), citizen.getPlaceOfBirth(), citizen.getSex());
	}
}