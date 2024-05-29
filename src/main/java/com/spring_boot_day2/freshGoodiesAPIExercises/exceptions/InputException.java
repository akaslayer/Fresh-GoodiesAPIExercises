package com.spring_boot_day2.freshGoodiesAPIExercises.exceptions;

import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;

public class InputException extends RuntimeException {
    private HttpStatus httpStatus;
    private List<String> errors;
    private Object data;

    public InputException(String message){
        this(HttpStatus.BAD_REQUEST,message);
    }

    public InputException(HttpStatus httpStatus, String message) {
        this(httpStatus, message, Collections.singletonList(message), null);
    }

    public InputException(HttpStatus httpStatus, String message, List<String> errors, Object data) {
        super(message);
        this.httpStatus = httpStatus;
        this.errors = errors;
        this.data = data;
    }
}
