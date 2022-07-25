package com.barclays.homeloan.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barclays.homeloan.entity.Loan;
import com.barclays.homeloan.entity.LoanApplication;
import com.barclays.homeloan.entity.SavingAccount;
import com.barclays.homeloan.repository.LoanApplicationRepository;
import com.barclays.homeloan.repository.LoanRepository;
import com.barclays.homeloan.repository.SavingRepository;

@Service
public class LoanApplicationService {

	
	@Autowired
	private SavingRepository savingRep;
	
	@Autowired
	private LoanApplicationRepository loanAppRepository;
	
	@Autowired
	private LoanRepository loanRepository;

	public LoanApplication addrequest(LoanApplication req) {
		
		LoanApplication newApp = new LoanApplication();
		newApp.setAddress(req.getAddress());
		newApp.setEmail(req.getEmail());
		newApp.setLoanAmount(req.getLoanAmount());
		newApp.setMonthlySalary(req.getMonthlySalary());
		newApp.setTenure(req.getTenure());
		
		return loanAppRepository.save(newApp);
	}

	public String validate(int id) {
		
		LoanApplication app = loanAppRepository.findById(id).get();
		int monthlySalary = app.getMonthlySalary();
		if(monthlySalary*50<app.getLoanAmount()) {
			return "Declined: loan should be less than monthlyincome*50";
		}
		
		Loan newLoan = new Loan();
		newLoan.setInterest(0.07f);
		newLoan.setLoanAmount(app.getLoanAmount());
		newLoan.setStatus("Ongoing");
		newLoan.setTenure(app.getTenure());
		newLoan.setStatus("approved");
		
		System.out.println(app.getEmail());
		
		SavingAccount savAcc = savingRep.findByEmail(app.getEmail());
		newLoan.setSavingAccount(savAcc.getSeqId());
		
		Loan savedLoan = loanRepository.save(newLoan);
		
		
		app.setLoanId(savedLoan.getId());
		loanAppRepository.save(app);
		
		return "Loan Approved Successfully !!";
	}
	
}
