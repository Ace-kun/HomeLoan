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

import com.barclays.homeloan.entity.LoanApplication;
import com.barclays.homeloan.repository.LoanApplicationRepository;
import com.barclays.homeloan.service.LoanApplicationService;

@RestController
public class LoanApplicationController {
	
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());


	
	@Autowired
	LoanApplicationRepository loanAppRepository;
	
	@Autowired
	LoanApplicationService loanAppService;
	@GetMapping(value = "/getLoan")
	public ResponseEntity<?> findAll(){
		//System.out.println("testtt");
		try {
			logger.info("api running !!");
			return new ResponseEntity<>(loanAppService.getAllLoan(), HttpStatus.OK);
		}
		catch(Exception e){
			logger.error("Error occurred while fetching all loan data: " + e.getMessage());
            return new ResponseEntity<>("Error occurred while fetching all loan data", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value = "/apply")
	public ResponseEntity<?>applyHomeLoan(@RequestBody LoanApplication req) {
		try {
			return new ResponseEntity<>(loanAppService.addrequest(req), HttpStatus.CREATED);
		}
		catch(Exception e){
			logger.error("Error occurred while adding Account: " + e.getMessage());
            return new ResponseEntity<>("Error occurred while adding Account", HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}
	
	@GetMapping(value = "/validate/{id}")
	public ResponseEntity<?> validateApplication(@PathVariable int id){
		try {
			if(loanAppService.validate(id)==null) {
				return new ResponseEntity<>("LoanApplication with given Id not present", HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<>(loanAppService.validate(id), HttpStatus.OK);
		}
		catch(Exception e){
			logger.error("Error occurred validating: " + e.getMessage());
            return new ResponseEntity<>("Error occurred while validating ", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping(value = "/loanApplication/{id}")
	public ResponseEntity<?> loanApplication(@PathVariable int id){
		try {
			return new ResponseEntity<>(loanAppService.getLoanApplicationById(id), HttpStatus.OK);
			
		}
		catch(Exception e){
			logger.error("Error occurred validating: " + e.getMessage());
            return new ResponseEntity<>("Error occurred while validating ", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

}
