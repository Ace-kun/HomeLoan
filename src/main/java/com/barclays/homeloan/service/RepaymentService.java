package com.barclays.homeloan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barclays.homeloan.entity.Repayment;
import com.barclays.homeloan.repository.RepaymentRepository;

@Service
public class RepaymentService {
	
	@Autowired 
	private RepaymentRepository repaymentRepository;

	public List<Repayment> getAllRepaymentDetails() {
		
		return repaymentRepository.findAll();
	}

}
