package com.barclays.homeloan.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.homeloan.repository.LoanRepository;
import com.barclays.homeloan.service.LoanService;

@RestController
public class LoanController {
	
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());


	
	@Autowired
	LoanRepository loanRepository;
	
	@Autowired
	LoanService loanService;
	
	
//	@PostMapping(value = "/addSavingAccount")
//	public ResponseEntity<?>(@RequestBody LoanAccount acc) {
//		try {
//			return new ResponseEntity<>(savingService.addAccount(acc), HttpStatus.CREATED);
//		}
//		catch(Exception e){
//			logger.error("Error occurred while adding Account: " + e.getMessage());
//            return new ResponseEntity<>("Error occurred while adding Account", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//	}

//	@PostMapping(value = "/addSavingAccount")
//	public ResponseEntity<?> addAccount(@RequestBody SavingAccount acc) {
//		try {
//			return new ResponseEntity<>(savingService.addAccount(acc), HttpStatus.CREATED);
//		}
//		catch(Exception e){
//			logger.error("Error occurred while adding Account: " + e.getMessage());
//            return new ResponseEntity<>("Error occurred while adding Account", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//	}

}
