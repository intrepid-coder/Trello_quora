package com.upgrad.quora.api.exception;/* Create by Mansi Elhance */

import com.upgrad.quora.api.model.ErrorResponse;
import com.upgrad.quora.service.exception.AuthenticationFailedException;
import com.upgrad.quora.service.exception.SignOutRestrictedException;
import com.upgrad.quora.service.exception.SignUpRestrictedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class RestExceptionHandler {

    //Handler for SignUpRestrictedException
    @ExceptionHandler(SignUpRestrictedException.class)
    public ResponseEntity<ErrorResponse> signUpRestrictedException(SignUpRestrictedException exe, WebRequest request){
        return new ResponseEntity<ErrorResponse>(
                new com.upgrad.quora.api.model.ErrorResponse().code(exe.getCode()).message(exe.getErrorMessage()), HttpStatus.FORBIDDEN
        );
    }

    //Handler for AuthenticationFailedException
    @ExceptionHandler(AuthenticationFailedException.class)
    public ResponseEntity<ErrorResponse> authenticationFailedException(AuthenticationFailedException exe, WebRequest request){
        return new ResponseEntity<ErrorResponse>(
                new com.upgrad.quora.api.model.ErrorResponse().code(exe.getCode()).message(exe.getErrorMessage()),HttpStatus.UNAUTHORIZED
        );
    }

    //Handler for SignOutRestrictedException
    @ExceptionHandler(SignOutRestrictedException.class)
    public ResponseEntity<ErrorResponse> signOutRestrictedException(SignOutRestrictedException exe, WebRequest request){
        return new ResponseEntity<ErrorResponse>(
                new com.upgrad.quora.api.model.ErrorResponse().code(exe.getCode()).message(exe.getErrorMessage()),HttpStatus.UNAUTHORIZED
        );
    }

}
