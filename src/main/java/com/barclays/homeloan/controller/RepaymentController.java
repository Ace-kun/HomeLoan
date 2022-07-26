package com.barclays.homeloan.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.homeloan.repository.RepaymentRepository;
import com.barclays.homeloan.service.RepaymentService;
import com.barclays.homeloan.utils.TenureReqUtil;

@RestController
public class RepaymentController {
	
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());


	
	@Autowired
	RepaymentRepository repayRepository;
	
	@Autowired
	RepaymentService repayService;
	
	
	@GetMapping(value = "/getEmi/{id}")
	public ResponseEntity<?> findEmiById(@PathVariable int id){
		try {
			logger.info("api running !!");
			return new ResponseEntity<>(repayService.getEmiById(id), HttpStatus.OK);
		}
		catch(Exception e){
			logger.error("Error occurred while fetching all EMIs data: " + e.getMessage());
            return new ResponseEntity<>("Error occurred while fetching all EMIs data", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "/payEmi/{id}")
	public ResponseEntity<?> payEmi(@PathVariable int id){
		try {
			
			return new ResponseEntity<>(repayService.payEmi(id), HttpStatus.OK);
		}
		catch(Exception e){
			logger.error("Error occurred while fetching all EMIs data: " + e.getMessage());
            return new ResponseEntity<>("Error occurred while fetching all EMIs data", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "/forPay/{id}")
	public ResponseEntity<?> forPayEmi(@PathVariable int id){
		try {
			
			return new ResponseEntity<>(repayService.forPayEmi(id), HttpStatus.OK);
		}
		catch(Exception e){
			logger.error("Error occurred while fetching all EMIs data: " + e.getMessage());
            return new ResponseEntity<>("Error occurred while fetching all EMIs data", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value = "/prePay/{id}")
	public ResponseEntity<?> prePayEmi(@PathVariable int id,@RequestBody TenureReqUtil req){
		try {
			
			return new ResponseEntity<>(repayService.prePayEmi(id,req.getMonths()), HttpStatus.OK);
		}
		catch(Exception e){
			logger.error("Error occurred while fetching all EMIs data: " + e.getMessage());
            return new ResponseEntity<>("Error occurred while fetching all EMIs data", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


}
