package com.barclays.homeloan.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.homeloan.repository.RepaymentRepository;
import com.barclays.homeloan.service.RepaymentService;

@RestController
public class RepaymentController {
	
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());


	
	@Autowired
	RepaymentRepository repaymentRepository;
	
	@Autowired
	RepaymentService repaymentService;
	
	@GetMapping(value = "/repay")
	public ResponseEntity<?> findAll(){
		try {
			logger.info("api running !!");
			return new ResponseEntity<>(repaymentService.getAllRepaymentDetails(), HttpStatus.OK);
		}
		catch(Exception e){
			logger.error("Error occurred while fetching all repayment data: " + e.getMessage());
            return new ResponseEntity<>("Error occurred while fetching all repayment data", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
//	
//	@GetMapping("/")
//	public static String homePage() {
//		return "this is home";
//	}

}
