package com.barclays.homeloan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barclays.homeloan.entity.SavingAccount;
import com.barclays.homeloan.repository.SavingRepository;

@Service
public class SavingService {
	
	@Autowired
	private SavingRepository savingRepository;

	public List<SavingAccount> getAllAccounts() {
		
		return savingRepository.findAll();
	}

	public SavingAccount addAccount(SavingAccount acc) {
		
		SavingAccount newAcc = new SavingAccount();
		newAcc.setAccountNumber(acc.getAccountNumber());
		newAcc.setBalance(acc.getBalance());
		newAcc.setEmail(acc.getEmail());
		newAcc.setName(acc.getName());
		return savingRepository.save(newAcc);
	}

}
