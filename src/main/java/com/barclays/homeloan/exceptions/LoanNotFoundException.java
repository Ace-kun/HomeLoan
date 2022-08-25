package com.barclays.homeloan.exceptions;

public class LoanNotFoundException extends RuntimeException{

    public LoanNotFoundException(int id){
        super(String.format("Loan with given id %d not found !",id));
    }
}
