package com.demo.interest_calculator.entity;

import com.demo.interest_calculator.validation.ValidInput;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "calculator")
public class Calculator {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="calculator_id")
	private Long id;

	@Column(name="user_id")
	private int userId;

	@NotNull(message = "Amount is required")
	@Min(value = 1, message= "Amount must be greater than 0")
	@Max(value = 999999999, message= "too big value")
	private Float amount;

	@NotNull(message = "Interest rate is required")
	@Min(value = 0, message = "Interest rate must be positive")
	@Max(value = 100, message= "too big value")
	private Float interest;

	@NotNull(message = "Months are required")
	@Min(value = 1, message = "Months must be at least 1")
	@Max(value = 999, message= "Must be less than or equal 999")
	private Integer months;

	@Column(name = "date_created")
	@CreationTimestamp
	private Date dateCreated;

	@Column(name = "last_updated")
	@UpdateTimestamp
	private Date last_updated;

	@Column(name="offers_name")
//	@NotNull(message = "is required")
//	@Size(min=1, message= "is required") //Only for String
//	@Size(max=5, message= "too big value") //Only for String
//	@Pattern(regexp = "^[a-zA-Z0-9 ]{25}", message ="0nly 24 chars/digits")
//	@ValidInput (value = "Loan", message = "must start with Loan")
	private String offerName = "";

	@Column(name="loan_amount")
	private BigDecimal loanAmount;
	@Column(name="interest_amount")
	private BigDecimal interestAmount;
}

