package com.barclays.homeloan.exceptions;

public class LoanApplicationNotFound extends RuntimeException{

    public LoanApplicationNotFound(int id){
        super(String.format("Loan Applicaiton with given id %d not found !",id));
    }
}
