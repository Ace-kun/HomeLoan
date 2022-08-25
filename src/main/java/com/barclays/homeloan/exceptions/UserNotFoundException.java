package com.barclays.homeloan.exceptions;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(int id){
        super(String.format("user with given id %d not found !",id));
    }
}
