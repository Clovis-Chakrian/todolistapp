package com.clovischakrian.todolist.controllers;

import com.clovischakrian.todolist.dtos.ApiResponse;
import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ApiResponse> validationExceptionHandler(ValidationException exception) {
        List<String> erros = new ArrayList<>();
        erros.add(exception.getMessage());

        return new ResponseEntity<>(new ApiResponse(false, null, erros), HttpStatus.BAD_REQUEST);
    }
}
