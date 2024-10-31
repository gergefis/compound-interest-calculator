package com.demo.interest_calculator.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

	@NotNull(message = "is required")
	@Min(value = 1, message= "is required") //Only for String
	@Max(value = 999999999, message= "too big value")
	private Float amount;

	@NotNull(message = "is required")
	@Min(value = 1, message= "is required")
	@Max(value = 100, message= "too big value")
	private Float interest;

	@NotNull(message = "is required")
	@Min(value = 1, message= "Must be greater than or equal to 12")
	@Max(value = 999, message= "Must be less than or equal 999")
	private Integer months;

	@Column(name="offers_name")
//	@NotNull(message = "is required")
//	@Size(min=1, message= "is required") //Only for String
//	@Size(max=5, message= "too big value") //Only for String
	private String offerName = "";

	@Column(name="loan_amount")
	private BigDecimal loanAmount;
	@Column(name="interest_amount")
	private BigDecimal interestAmount;
}

