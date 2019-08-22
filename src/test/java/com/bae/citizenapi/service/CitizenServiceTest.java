package com.bae.citizenapi.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.citizenapi.model.Citizen;
import com.bae.citizenapi.repository.CitizenRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CitizenServiceTest {

	@InjectMocks
	CitizenServiceImplementation service;

	@Mock
	CitizenRepository repository;

	private static final Date birthday = new Date(03 / 12 / 1987);
	private static final Date birthday2 = new Date(03 / 11 / 1980);

	private static final Citizen MOCK_CITIZEN = new Citizen(1L, "Marc", "Partington", "6 Awesome Street", birthday,
			"Milton Keynes", "Male");
	private static final Citizen MOCK_CITIZEN_2 = new Citizen(2L, "Jun", "Awesomo", "90 Kebab Close", birthday2,
			"Gloucester", "Male");

	private List<Citizen> MOCK_LIST = new ArrayList<>();

	@Test
	public void getCitizenTest() {
		MOCK_LIST.add(MOCK_CITIZEN);
		Mockito.when(repository.findCitizens(1L, "Marc", "Partington", "6 Awesome Street", birthday, "Milton Keynes",
				"Male")).thenReturn(MOCK_LIST);
		assertEquals(MOCK_LIST, service.getCitizens(MOCK_CITIZEN));
		Mockito.verify(repository).findCitizens(1L, "Marc", "Partington", "6 Awesome Street", birthday, "Milton Keynes",
				"Male");

	}

}
