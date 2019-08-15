package com.example.springbatchexample1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbatchexample1.model.Citizen;
import com.example.springbatchexample1.repository.CitizenRepository;

@Service
public class CitizenServiceImplementation implements CitizenService {

	private CitizenRepository citizenRepository;

	@Autowired
	public CitizenServiceImplementation(CitizenRepository citizenRepository) {
		this.citizenRepository = citizenRepository;
	}

	@Override
	public List<Citizen> getCitizens(Citizen citizen) {
		return citizenRepository.findCitizens(citizen.getCitizenId(), citizen.getForenames(),
				citizen.getSurname(), citizen.getHomeAddress(), citizen.getDateOfBirth(), citizen.getPlaceOfBirth(),
				citizen.getSex());
	}
}