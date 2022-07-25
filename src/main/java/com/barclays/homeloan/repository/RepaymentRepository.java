package com.barclays.homeloan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.barclays.homeloan.entity.Repayment;

@Repository
public interface RepaymentRepository extends JpaRepository<Repayment,Integer>{

}
