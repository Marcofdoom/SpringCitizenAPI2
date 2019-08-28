package com.bae.citizenapi.persistence;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.citizenapi.domain.model.Citizen;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CitizenModelTests {

	@InjectMocks
	Citizen citizen;

	private static final Date BIRTHDAY = new Date(03 / 12 / 1987);

	private static final Citizen MOCK_CITIZEN = new Citizen(1L, "Marc", "Partington", "6 Awesome Street", BIRTHDAY,
			"Milton Keynes", "Male");

	@Test
	public void getForenamesTest() {
		assertEquals("Marc", MOCK_CITIZEN.getForenames());
	}

	@Test
	public void getSurnameTest() {
		assertEquals("Partington", MOCK_CITIZEN.getSurname());
	}

	@Test
	public void getAddressTest() {
		assertEquals("6 Awesome Street", MOCK_CITIZEN.getHomeAddress());
	}

	@Test
	public void getDOBTest() {
		assertEquals(BIRTHDAY, MOCK_CITIZEN.getDateOfBirth());
	}

	@Test
	public void getPOBTest() {
		assertEquals("Milton Keynes", MOCK_CITIZEN.getPlaceOfBirth());
	}

	@Test
	public void getSexTest() {
		assertEquals("Male", MOCK_CITIZEN.getSex());
	}

}
