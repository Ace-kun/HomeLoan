package com.barclays.homeloan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barclays.homeloan.entity.Loan;
import com.barclays.homeloan.entity.Repayment;
import com.barclays.homeloan.repository.LoanRepository;
import com.barclays.homeloan.repository.RepaymentRepository;

@Service
public class RepaymentService {

	@Autowired
	private LoanRepository loanRepository;
	
	@Autowired
	private RepaymentRepository repayRepository;

	public Repayment getEmiById(int id) {
		
		Optional<Repayment> repayment = repayRepository.findById(id);
		
		return repayment.get();
		
	}

	public List<Repayment> payEmi(int id) {
		
		Loan loan = loanRepository.findById(id).get();
		
		int savingAccountId = loan.getSavingAccount();
		
		List<Repayment> lst = repayRepository.findByLoanIdAndStatus(loan, "Pending");
		
		System.out.println(lst);
		
		return lst;
	}
	
	
	
}
