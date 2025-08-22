package com.works.configs;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Object handler( MethodArgumentNotValidException ex ) {
        return parseError(ex.getFieldErrors());
    }

    private List parseError(List<FieldError> fieldErrors) {
        List errors = new ArrayList();
        for (FieldError fieldError : fieldErrors) {
            Map<String, Object> error = new HashMap<>();
            error.put("field", fieldError.getField());
            error.put("message", fieldError.getDefaultMessage());
            error.put("rejectedValue", fieldError.getRejectedValue());
            errors.add(error);
        }
        return errors;
    }

}
