package com.mehmetyilmaz.issuemanagement.advice;


import com.sun.javafx.tools.packager.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@ControllerAdvice // controller e advice olacagi anlamina geliyor
@Slf4j
public class IMExceptionHandler extends ResponseEntityExceptionHandler {

    // sistem uzerinde alinan tum exceptionlar bu yapiyla donecek...
    @ExceptionHandler(Exception.class )
    public final ResponseEntity<?> handleExceptions (Exception ex, WebRequest request) {

        log.debug("ControllerAdvice -> IMExceptionHandler -> ex -> " , ex, request);
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage());
        return new ResponseEntity<>( exceptionResponse, HttpStatus.EXPECTATION_FAILED);
    }
}
