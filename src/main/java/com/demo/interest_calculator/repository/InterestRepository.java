package com.demo.interest_calculator.repository;

import com.demo.interest_calculator.entity.Calculator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "calculator", path = "offer-list")
public interface InterestRepository extends JpaRepository<Calculator, Long> {


}
