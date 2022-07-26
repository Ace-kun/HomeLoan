package com.barclays.homeloan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barclays.homeloan.entity.Loan;
import com.barclays.homeloan.entity.User;
import com.barclays.homeloan.repository.LoanRepository;

@Service
public class LoanService {

	
	@Autowired
	private LoanRepository loanRepository;

}
