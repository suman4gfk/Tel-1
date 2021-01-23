package com.infosys.wecare.exception;

import com.infosys.wecare.dto.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(Exception.class)
    public String exceptionHandler(Exception ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(WecareException.class)
    public ResponseEntity<ErrorMessage> exceptionHandler(WecareException e) {
        ErrorMessage er = new ErrorMessage();
        er.setMessage(e.getMessage());
        return new ResponseEntity<>(er, HttpStatus.OK);
    }
}
