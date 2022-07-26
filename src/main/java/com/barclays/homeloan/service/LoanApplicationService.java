package com.barclays.homeloan.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barclays.homeloan.entity.Loan;
import com.barclays.homeloan.entity.LoanApplication;
import com.barclays.homeloan.entity.Repayment;
import com.barclays.homeloan.entity.SavingAccount;
import com.barclays.homeloan.repository.LoanApplicationRepository;
import com.barclays.homeloan.repository.LoanRepository;
import com.barclays.homeloan.repository.RepaymentRepository;
import com.barclays.homeloan.repository.SavingRepository;
import com.barclays.homeloan.utils.EmiManager;

@Service
public class LoanApplicationService {

	@Autowired
	private EmiManager emiManager;
	
	@Autowired
	private RepaymentRepository repaymentRepository;
	
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
			
			app.setStatus("Declined");
			loanAppRepository.save(app);
			return "Declined: loan should be less than monthlyincome*50";
		}
		
		app.setStatus("approved");
		
		createLoan(app);
		
		return "Loan Approved Successfully !!";
	}
	
	public void createLoan(LoanApplication app) {
		
		Loan newLoan = new Loan();
		newLoan.setInterest(0.07f);
		newLoan.setLoanAmount(app.getLoanAmount());
		newLoan.setStatus("Approved");
		newLoan.setTenure(app.getTenure());
		
		
		SavingAccount savAcc = savingRep.findByEmail(app.getEmail());
		newLoan.setSavingAccount(savAcc.getSeqId());
		
		Loan savedLoan = loanRepository.save(newLoan);
		
		
		app.setLoanId(savedLoan.getId());
		loanAppRepository.save(app);
		
		createRepaymentEmi(savedLoan);
		
	}

	private void createRepaymentEmi(Loan loan) {
		
		float amt = loan.getLoanAmount();
		int tenure = loan.getTenure();
		
		float emi = emiManager.CalculateEmi(amt, tenure);
		LocalDate date = LocalDate.now().plusMonths(1);   
		float rate = emiManager.INTEREST;
		
		for(int i=0;i<tenure;i++) {
			
			float interest = amt * rate;
			float principal = emi - interest;
			Repayment rp = new Repayment();
			rp.setEmi(emi);
			rp.setInterestamount(interest);
			rp.setPrincipalamount(principal);
			rp.setOutstanding(amt);
			rp.setDate(date);
			rp.setStatus("Pending");
			rp.setLoanId(loan);
			repaymentRepository.save(rp);
			
			amt = amt-principal;
			date = date.plusMonths(1);
			
		}
		
		
		
	}
	
}
