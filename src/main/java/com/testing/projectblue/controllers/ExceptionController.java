package com.testing.projectblue.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(exception = ArithmeticException.class)
    public String handleException(Exception e) {
        // Log the exception (you can use a logging framework like Log4j or SLF4J)
        System.err.println("An error occurred: " + e.getMessage());
        System.out.println("Bhushan this is the exception:"+e.getMessage());
        // Return a generic error message to the client
        return "An unexpected error occurred. Please try again later.";
    }
    @ExceptionHandler(exception = RuntimeException.class)
    public String handleGenericException(Exception e) {
        // Log the exception (you can use a logging framework like Log4j or SLF4J)
        System.err.println("An error occurred: " + e.getMessage());
        System.out.println("Bhushan this is Runtime Exception:"+e.getMessage());
        // Return a generic error message to the client
        return "An unexpected error occurred. Please try again later.";
    }

}
