/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author vivien saa
 */
@ControllerAdvice
public class CamerLocalCustomExceptionHandler extends ResponseEntityExceptionHandler {

    private final String RECORD_NOT_FOUND = "RECORD_NOT_FOUND";
    private final String BAD_REQUEST = "BAD_REQUEST";
    private final String INTERNAL_SERVER_ERROR = "INTERNAL_SERVER_ERROR";
    private final String UNAUTHORIZED_REQUEST = "UNAUTHORIZED_REQUEST";
    private final String USER_NOT_FOUND = "USER_NOT_FOUND";

    @ExceptionHandler(RecordNotFoundException.class)
    public final ResponseEntity<ErrorResponse> handleRecordNotFoundException(RecordNotFoundException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse(new Date(), RECORD_NOT_FOUND, details);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InternalServerException.class)
    public final ResponseEntity<ErrorResponse> handleInternalServerException(InternalServerException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse(new Date(), INTERNAL_SERVER_ERROR, details);
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UnAuthorizedRequestException.class)
    public final ResponseEntity<ErrorResponse> handleUnAuthorizedRequestException(UnAuthorizedRequestException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse(new Date(), UNAUTHORIZED_REQUEST, details);
        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = {UserNotFoundException.class, UsernameNotFoundException.class})
    public final ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException ex1, UsernameNotFoundException ex2, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add((ex1 == null) ? ex2.getLocalizedMessage() : ex1.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse(new Date(), USER_NOT_FOUND, details);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
