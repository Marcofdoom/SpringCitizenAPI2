package com.bae.citizenapi.domain.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;

import com.bae.citizenapi.domain.model.Citizen;
import com.bae.citizenapi.domain.repository.CitizenRepository;

@Repository
public class CitizenDAO {

	private CitizenRepository citizenRepository;

	@Autowired
	public CitizenDAO(CitizenRepository citizenRepository) {
		this.citizenRepository = citizenRepository;
	}

	public List<Citizen> findCitizen(Example<Citizen> citizen) {
		return citizenRepository.findAll(citizen);
	}
}
