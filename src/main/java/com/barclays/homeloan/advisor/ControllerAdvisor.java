package com.barclays.homeloan.advisor;

import com.barclays.homeloan.entity.LoanApplication;
import com.barclays.homeloan.exceptions.LoanApplicationNotFound;
import com.barclays.homeloan.exceptions.LoanNotFoundException;
import com.barclays.homeloan.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> handleUserNotFoundException(UserNotFoundException ex){
        Map<String,Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDate.now());
        body.put("message","User Not Found");

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(LoanNotFoundException.class)
    public ResponseEntity<?> handleLoanNotFoundException(LoanNotFoundException ex){
        Map<String ,Object> body = new LinkedHashMap<>();
        body.put("timestamp",LocalDate.now());
        body.put("message","Loan Not Found");

        return new ResponseEntity<>(body,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(LoanApplicationNotFound.class)
    public ResponseEntity<?> handleLoanApplicationNotFoundException(LoanApplicationNotFound ex){
        Map<String,Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDate.now());
        body.put("message","Loan Application Not Found !");

        return new ResponseEntity<>(body,HttpStatus.NOT_FOUND);
    }
}
