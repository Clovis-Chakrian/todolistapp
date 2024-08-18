package com.clovischakrian.todolist.controllers;

import com.clovischakrian.todolist.dtos.ApiResponse;
import com.clovischakrian.todolist.entities.Task;
import com.clovischakrian.todolist.services.ITaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController("api/tasks")
public class TodoController {
    private final ITaskService taskService;

    public TodoController(ITaskService taskService) {
        this.taskService = taskService;
    }

    public<T> ResponseEntity<ApiResponse<T>> ApiResponse(T data) {
        return new ResponseEntity<ApiResponse<T>>(new ApiResponse<T>(true, data, new ArrayList<>()), HttpStatus.OK);
    }

    public<T> ResponseEntity<ApiResponse<T>> ApiResponse(T data, HttpStatus statusCode) {
        return new ResponseEntity<ApiResponse<T>>(new ApiResponse<T>(true, data, new ArrayList<>()), statusCode);
    }

    @GetMapping()
    public ResponseEntity<ApiResponse<List<Task>>> ObterTasks() {
        return this.ApiResponse(this.taskService.listTasks());
    }

}
