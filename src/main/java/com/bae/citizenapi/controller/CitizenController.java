package com.bae.citizenapi.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bae.citizenapi.model.Citizen;
import com.bae.citizenapi.service.CitizenService;

@RestController
@RequestMapping("/Citizen")
public class CitizenController {

	private CitizenService service;

	public CitizenController() {

	}

	@Autowired
	public CitizenController(CitizenService service) {
		this.service = service;
	}

	@GetMapping("/getCitizens")
	public ResponseEntity<Object> getCitizens(@RequestParam(value = "citizenId", required = false) Long citizenId,
			@RequestParam(value = "forenames", required = false) String forenames,
			@RequestParam(value = "surname", required = false) String surname,
			@RequestParam(value = "homeAddress", required = false) String homeAddress,
			@RequestParam(value = "dateOfBirth", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateOfBirth,
			@RequestParam(value = "placeOfBirth", required = false) String placeOfBirth,
			@RequestParam(value = "sex", required = false) String sex) {

		Citizen citizenEntity = new Citizen(citizenId, forenames, surname, homeAddress, dateOfBirth, placeOfBirth, sex);

		return new ResponseEntity<>(service.findCitizen(citizenEntity), HttpStatus.OK);
	}
}