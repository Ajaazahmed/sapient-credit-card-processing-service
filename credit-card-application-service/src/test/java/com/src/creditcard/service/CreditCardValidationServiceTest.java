package com.src.creditcard.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.src.creditcard.service.CreditCardValidationService;

@RunWith(MockitoJUnitRunner.class)
public class CreditCardValidationServiceTest {
	
	@InjectMocks
	private CreditCardValidationService service;

	@Test
	public void shouldValidateCardNumbers() throws Exception {
		
		String number1 = "49927398716";
		assertTrue(service.isValidLuhnNumber(number1));
		
		String number2 = "8763";
		assertTrue(service.isValidLuhnNumber(number2));
		
		String number3 = "8673";
		assertFalse(service.isValidLuhnNumber(number3));

	}

}
