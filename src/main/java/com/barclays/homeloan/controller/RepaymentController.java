package com.barclays.homeloan.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.homeloan.repository.LoanRepository;
import com.barclays.homeloan.repository.RepaymentRepository;
import com.barclays.homeloan.service.LoanService;
import com.barclays.homeloan.service.RepaymentService;

@RestController
public class RepaymentController {
	
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());


	
	@Autowired
	RepaymentRepository repayRepository;
	
	@Autowired
	RepaymentService repayService;
	


}
