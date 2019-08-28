package com.bae.citizenapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.bae.citizenapi.domain.dao.CitizenDAO;
import com.bae.citizenapi.domain.model.Citizen;

@Service
public class CitizenService {

	private CitizenDAO citizenDao;

	@Autowired
	public CitizenService(CitizenDAO citizenDao) {
		this.citizenDao = citizenDao;
	}

	public List<Citizen> findCitizen(Citizen probe) {
		return citizenDao.findCitizen(Example.of(probe, ExampleMatcher.matchingAll()
				.withMatcher("homeAddress", ExampleMatcher.GenericPropertyMatchers.contains()).withIgnoreCase()));
	}
}