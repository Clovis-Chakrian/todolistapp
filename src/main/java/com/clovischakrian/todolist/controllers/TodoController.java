package com.clovischakrian.todolist.controllers;

import com.clovischakrian.todolist.dtos.ApiResponse;
import com.clovischakrian.todolist.dtos.NewTaskDto;
import com.clovischakrian.todolist.entities.Task;
import com.clovischakrian.todolist.services.ITaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    public<T> ResponseEntity<ApiResponse<T>> apiResponse(T data) {
        return new ResponseEntity<ApiResponse<T>>(new ApiResponse<T>(true, data, null), HttpStatus.OK);
    }

    public<T> ResponseEntity<ApiResponse<T>> apiResponse(T data, HttpStatus statusCode) {
        return new ResponseEntity<ApiResponse<T>>(new ApiResponse<T>(true, data, null), statusCode);
    }

    @GetMapping()
    public ResponseEntity<ApiResponse<List<Task>>> getTasks() {
        return this.apiResponse(this.taskService.listTasks());
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<ApiResponse<Task>> getTaskById(@RequestParam UUID taskId) {
        return this.apiResponse(this.taskService.detailTask(taskId));
    }

    @PostMapping()
    public ResponseEntity<ApiResponse<UUID>> createTask(@RequestBody NewTaskDto newTaskDto) {
        return this.apiResponse(this.taskService.createTask(newTaskDto));
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<ApiResponse<UUID>> deleteTask(@RequestParam UUID taskId) {
        return this.apiResponse(this.taskService.removeTask(taskId));
    }
}
