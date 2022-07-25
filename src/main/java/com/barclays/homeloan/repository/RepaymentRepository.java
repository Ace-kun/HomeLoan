package com.barclays.homeloan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barclays.homeloan.entity.Loan;


public interface RepaymentRepository extends JpaRepository<Loan,Integer> {

}
