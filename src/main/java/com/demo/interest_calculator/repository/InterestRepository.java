package com.demo.interest_calculator.repository;

import com.demo.interest_calculator.entity.Calculator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterestRepository extends JpaRepository<Calculator, Integer> {
	// add a method to sort by last name
//	public List<Interest> findAllByOrderByLastNameAsc();

}
