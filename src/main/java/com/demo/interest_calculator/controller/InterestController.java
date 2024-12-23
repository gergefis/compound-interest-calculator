package com.demo.interest_calculator.controller;

import com.demo.interest_calculator.dto.CalculationResponse;
import com.demo.interest_calculator.entity.Calculator;
import com.demo.interest_calculator.service.InterestService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.pow;

@RestController
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class InterestController {
	static final int MONTHS_OF_YEAR = 12;

	@Autowired
	private InterestService interestService;

	// add an initbinder ... to convert trim input strings
	// remove leading and trailing whitespace
	// resolve issue for our validation
	@InitBinder
	public void initBinder(WebDataBinder dataBinder){
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true); //true means trim empty string to null
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@GetMapping("/")
	public String homePage(Model model){
		model.addAttribute("calculator", new Calculator());
		return "index";
		}


	@PostMapping("/calculate")
	public ResponseEntity<CalculationResponse> calculator(@Valid @RequestBody Calculator calculator,
														  BindingResult result){
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}

		Float amount = calculator.getAmount();
		// Converts percentages to decimals
		double interestAmount = getTotalInterestAmount(calculator, amount);
		double loanAmount = interestAmount + amount;

		// Round results
		double roundedInterestNumber =  roundToTwoDecimalPlaces(interestAmount);
		double roundedLoanNumber = roundToTwoDecimalPlaces(loanAmount);

		// Return the response as JSON
		return ResponseEntity.ok(new CalculationResponse(roundedInterestNumber, roundedLoanNumber));

	}

	private double roundToTwoDecimalPlaces(double value) {
		return BigDecimal.valueOf(value)
				.setScale(2, RoundingMode.HALF_UP)
				.doubleValue();
	}

	/**
	 * Calculates the total interest amount and total loan amount based on the provided calculator data.
	 *
	 * @param calculator The calculator object containing the user's input.
	 * @param amount The principal loan amount.
	 * @return The total interest amount and total loan amount, rounded to two decimal places.
	 */
	private static double getTotalInterestAmount(Calculator calculator, Float amount) {
		Float interest = (calculator.getInterest() / 100);
		Integer months = calculator.getMonths();

//	Calculate the total Interest amount
		float firstFraction = (amount * months * interest) / MONTHS_OF_YEAR;
		double numerator =  pow((1 + (interest / MONTHS_OF_YEAR)), months);
		double secondFraction = (numerator / (numerator -1));
		double totalLoanAmount = (firstFraction * secondFraction) - amount;
		return totalLoanAmount;
	}

	@PostMapping("/saveLoanInfo")
	public String saveLoanInfo(@ModelAttribute("calculator") Calculator calculator, Model model){
		try {
			interestService.save(calculator);
			System.out.println(calculator.getLoanAmount());
			System.out.println(calculator.getInterestAmount());


			model.addAttribute("success", calculator);

			return "success";
		} catch (JpaSystemException e) {
			log.error("Data integrity violation: ", e);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Exception while saving recipe", e);
		}
	}

}
