package com.demo.interest_calculator.controller;

import com.demo.interest_calculator.entity.Calculator;
import com.demo.interest_calculator.service.InterestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.lang.Math.pow;

@Controller
@RequestMapping
@RequiredArgsConstructor
@Slf4j
public class InterestController {
	static final int MONTHS_OF_YEAR = 12;

	@Autowired
	private InterestService interestService;

	@GetMapping("/")
	public String homePage(Model model){
		Calculator calculator = new Calculator();
		model.addAttribute("calculator", calculator);
		return "index";
	}

	@PostMapping("/calculator")
	public String calculator(@ModelAttribute Calculator calculator,
							 Model model){

		Float amount = calculator.getAmount();
//	Converts percentages to decimals
		double totalInterestAmount = getTotalInterestAmount(calculator, amount);
		double	totalLoanAmount = totalInterestAmount + amount;

		BigDecimal number = new BigDecimal(totalInterestAmount);
		BigDecimal roundedInterestNumber = number.setScale(2, RoundingMode.HALF_UP);
		calculator.setInterestAmount(roundedInterestNumber);

		BigDecimal loanAmount = new BigDecimal (totalLoanAmount);
		BigDecimal roundedLoanNumber = loanAmount.setScale(2, RoundingMode.HALF_UP);
		calculator.setLoanAmount(roundedLoanNumber);

		model.addAttribute("totalInterestAmount", roundedInterestNumber);
		model.addAttribute("totalLoanAmount", roundedLoanNumber);
		model.addAttribute("calculator", calculator);

		return "index";
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
