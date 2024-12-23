package com.demo.interest_calculator.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CalculationResponse {
	private final double totalInterest;
	private final double totalAmount;

}
