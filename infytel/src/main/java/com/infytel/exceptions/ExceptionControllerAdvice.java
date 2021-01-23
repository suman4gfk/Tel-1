package com.infytel.exceptions;

import com.infytel.errors.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(Exception.class)
    public String exceptionHandler(Exception ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(NoSuchCustomerException.class)
    public ResponseEntity<ErrorMessage> exceptionHandler2(NoSuchCustomerException ex) {
        ErrorMessage er = new ErrorMessage();
        er.setErrorCode(HttpStatus.BAD_REQUEST.value());
        er.setMessage(ex.getMessage());
        return new ResponseEntity<>(er, HttpStatus.OK);
    }

    @ExceptionHandler(NoSuchProductException.class)
    public ResponseEntity<ErrorMessage> exceptionHandler2(NoSuchProductException ex) {
        ErrorMessage er = new ErrorMessage();
        er.setErrorCode(HttpStatus.BAD_REQUEST.value());
        er.setMessage(ex.getMessage());
        return new ResponseEntity<>(er, HttpStatus.OK);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> exceptionHandler3(MethodArgumentNotValidException ex) {
        ErrorMessage er = new ErrorMessage();
        er.setErrorCode(HttpStatus.BAD_REQUEST.value());
        er.setMessage(ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.
                        joining(",")));
        return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorMessage> exceptionHandler4(ConstraintViolationException ex) {
        ErrorMessage er = new ErrorMessage();
        er.setErrorCode(HttpStatus.BAD_REQUEST.value());
        er.setMessage(ex.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.
                        joining(",")));
        return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
    }

}
