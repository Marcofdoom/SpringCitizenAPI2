package com.bae.citizenapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.bae.citizenapi.model.Citizen;
import com.bae.citizenapi.repository.CitizenRepository;

@Service
public class CitizenServiceImplementation implements CitizenService {

	private CitizenRepository repository;

	@Autowired
	public CitizenServiceImplementation(CitizenRepository repository) {
		this.repository = repository;
	}

	public List<Citizen> findCitizen(Citizen probe) {
		return repository.findAll(Example.of(probe, ExampleMatcher.matchingAll()
				.withMatcher("homeAddress", ExampleMatcher.GenericPropertyMatchers.contains()).withIgnoreCase()));
	}
}