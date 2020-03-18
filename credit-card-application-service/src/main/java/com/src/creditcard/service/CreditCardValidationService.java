package com.src.creditcard.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CreditCardValidationService {

	public boolean isValidLuhnNumber(String number) {

		if ((number != null) && (!number.equals("") && (Long.parseLong(number) != 0)) && (number.matches("[0-9]+"))
				&& (number.length() < 20)) {
			log.debug("Checking if number {} is valid credit card number", number);

			// The following code has been taken from Google which i am already aware of.
			// Since the task says particularly to handcode the logic and not to use any
			// existing library.
			// I have written my own logic

			/*
			 * PrimitiveIterator.OfInt factor = IntStream.iterate(1, i -> 3 - i).iterator();
			 * 
			 * int sum = new
			 * StringBuilder(creditCardNumber).reverse().toString().chars().map(c -> c -
			 * '0') .map(i -> i * factor.nextInt()) .reduce(0, (a, b) -> a + b / 10 + b %
			 * 10); return (sum % 10) == 0;
			 */

			String reverserNumber = new StringBuilder(number).reverse().toString();
			List<Integer> digits = reverserNumber.chars().mapToObj(Character::getNumericValue)
					.collect(Collectors.toList());
			int total = 0;
			for (int i = 1; i <= digits.size(); i++) {
				total += checkSum(digits.get(i - 1), i);
			}
			return (total % 10) == 0;
		}
		return false;
	}

	private int checkSum(int num, int position) {
		int sum = num;
		if (position % 2 == 0) {
			sum = num * 2;
			if (sum > 9) {
				sum = String.valueOf(sum).chars().map(Character::getNumericValue).sum();
			}
		}
		return sum;
	}
}
