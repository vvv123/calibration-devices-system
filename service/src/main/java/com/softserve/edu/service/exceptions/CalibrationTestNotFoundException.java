package com.softserve.edu.service.exceptions;

public class CalibrationTestNotFoundException extends RuntimeException {
    public CalibrationTestNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CalibrationTestNotFoundException(String message) {
        super(message);
    }

    public CalibrationTestNotFoundException() {
    }
}