package com.barclays.homeloan.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Repayment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name = "local_date", columnDefinition = "DATE")
	private LocalDate date;
	
	@Column
	private int emi;
	
	@Column
	private int pricipalamount;
	
	@Column
	private int interestamount;
	
	@Column
	private int outstanding;

	@Column
	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getEmi() {
		return emi;
	}

	public void setEmi(int emi) {
		this.emi = emi;
	}

	public int getPricipalamount() {
		return pricipalamount;
	}

	public void setPricipalamount(int pricipalamount) {
		this.pricipalamount = pricipalamount;
	}

	public int getInterestamount() {
		return interestamount;
	}

	public void setInterestamount(int interestamount) {
		this.interestamount = interestamount;
	}

	public int getOutstanding() {
		return outstanding;
	}

	public void setOutstanding(int outstanding) {
		this.outstanding = outstanding;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Repayment(int id, LocalDate date, int emi, int pricipalamount, int interestamount, int outstanding,
			String status) {
		super();
		this.id = id;
		this.date = date;
		this.emi = emi;
		this.pricipalamount = pricipalamount;
		this.interestamount = interestamount;
		this.outstanding = outstanding;
		this.status = status;
	}
	
	
	
	

}
