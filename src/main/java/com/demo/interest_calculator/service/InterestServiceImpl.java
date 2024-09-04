package com.demo.interest_calculator.service;

import com.demo.interest_calculator.model.Calculator;
import com.demo.interest_calculator.repository.InterestRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InterestServiceImpl implements InterestService {

	@Autowired // TODO - I want to check Constructors also on Recipeat
	private InterestRepository interestRepository;

	@Override
	public void save(Calculator calculator) {
		interestRepository.save(calculator);
	}
}
