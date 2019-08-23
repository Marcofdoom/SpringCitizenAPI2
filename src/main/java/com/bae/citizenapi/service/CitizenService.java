package com.bae.citizenapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bae.citizenapi.model.Citizen;

@Service
public interface CitizenService {

	public List<Citizen> findCitizen(Citizen citizen);
}