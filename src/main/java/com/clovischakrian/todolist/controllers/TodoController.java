package com.clovischakrian.todolist.controllers;

import com.clovischakrian.todolist.dtos.ApiResponse;
import com.clovischakrian.todolist.entities.Task;
import com.clovischakrian.todolist.services.ITaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("/api/tasks")
public class TodoController {
    private final ITaskService taskService;

    public TodoController(ITaskService taskService) {
        this.taskService = taskService;
    }

    public<T> ResponseEntity<ApiResponse<T>> ApiResponse(T data) {
        return new ResponseEntity<ApiResponse<T>>(new ApiResponse<T>(true, data, null), HttpStatus.OK);
    }

    public<T> ResponseEntity<ApiResponse<T>> ApiResponse(T data, HttpStatus statusCode) {
        return new ResponseEntity<ApiResponse<T>>(new ApiResponse<T>(true, data, null), statusCode);
    }

    @GetMapping()
    public ResponseEntity<ApiResponse<List<Task>>> ObterTasks() {
        return this.ApiResponse(this.taskService.listTasks());
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<ApiResponse<Task>> ObterTask(@RequestParam UUID taskId) {
        return this.ApiResponse(this.taskService.detailTask(taskId));
    }

}
