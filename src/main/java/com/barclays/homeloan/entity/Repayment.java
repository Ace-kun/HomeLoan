package com.barclays.homeloan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Loan_Repayment")
public class Repayment {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="EMI")
	private int EMI;
	
	@Column(name="principal_amount")
	private int principal_amount;
	
	@Column(name="intrest_amount")
	private int intrest_amount;
	
	//outstanding - It means closing after EMI deduction
	@Column(name="outstanding")
	private int outstanding;
	
	//status - pending/paid/cancelled
	@Column(name="status")
	private String status;
	
	@Column(name="date")
	private String date;
	
	public Repayment() {};

	public Repayment(int id, int EMI, int principal_amount, int intrest_amount, int outstanding, String status, String date) {
		super();
		this.id = id;
		this.EMI = EMI;
		this.principal_amount = principal_amount;
		this.intrest_amount = intrest_amount;
		this.outstanding = outstanding;
		this.status = status;
		this.date = date;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEMI() {
		return EMI;
	}

	public void setEMI(int EMI) {
		this.EMI = EMI;
	}

	public int getPrincipalAmount() {
		return principal_amount;
	}

	public void setPrincipalAmount(int principal_amount) {
		this.principal_amount = principal_amount;
	}

	public int getIntrestAmount() {
		return intrest_amount;
	}

	public void setIntrestAmount(int intrest_amount) {
		this.intrest_amount = intrest_amount;
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
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}	
	

}
