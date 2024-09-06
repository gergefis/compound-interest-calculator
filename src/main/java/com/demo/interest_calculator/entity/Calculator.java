package com.demo.interest_calculator.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "calculator")
public class Calculator {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="calculator_id")
	private int id;

	@Column(name="user_id")
	private int userId;

	private Float amount;
	private Float interest;
	private Integer months;

	@Column(name="offers_name")
	private String offerName;
	@Column(name="loan_amount")
	private BigDecimal loanAmount;
	@Column(name="interest_amount")
	private BigDecimal interestAmount;
}

