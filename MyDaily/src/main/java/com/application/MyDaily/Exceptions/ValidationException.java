package com.application.MyDaily.Exceptions;

public class ValidationException extends Exception {
    private String message;
    
    public ValidationException(String message) {
    	
    }
    
    public String getMessage() {
    	return message;
    }
}