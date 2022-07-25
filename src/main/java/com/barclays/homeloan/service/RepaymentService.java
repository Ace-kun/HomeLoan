package com.barclays.homeloan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barclays.homeloan.repository.LoanRepository;
import com.barclays.homeloan.repository.RepaymentRepository;

@Service
public class RepaymentService {

	
	@Autowired
	private RepaymentRepository repayRepository;
	
}
