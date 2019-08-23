package com.bae.citizenapi.controller;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.citizenapi.service.CitizenService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CitizenControllerTests {

	@InjectMocks
	CitizenController controller;

	@Mock
	CitizenService service;

//	private static final Date birthday = new Date(03 / 12 / 1987);
//
//	private static final Citizen MOCK_CITIZEN = new Citizen(1L, "Marc", "Partington", "6 Awesome Street", birthday,
//			"Milton Keynes", "Male");
//
//	private static final List<Citizen> MOCK_LIST = new ArrayList<>();
//
//	@Test
//	public void getCitizen() {
//
//		MOCK_LIST.add(MOCK_CITIZEN);
//		System.out.println(MOCK_LIST.get(0).getForenames());
//		Mockito.when(service.getCitizens(MOCK_CITIZEN)).thenReturn(MOCK_LIST);
//		assertEquals(MOCK_CITIZEN,
//				controller.getCitizens(1L, "Marc", "Partington", "6 Awesome Street", birthday, "Milton Keynes", "Male")
//						.getBody());
//		Mockito.verify(service).getCitizens(MOCK_CITIZEN);
//
//	}

}
