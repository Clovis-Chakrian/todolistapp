package com.clovischakrian.todolist.services;

import com.clovischakrian.todolist.dtos.NewTaskDto;
import com.clovischakrian.todolist.dtos.UpdatedTaskDto;
import com.clovischakrian.todolist.entities.Task;
import jakarta.validation.ValidationException;

import java.util.List;
import java.util.UUID;

public interface ITaskService {
    public UUID createTask(NewTaskDto newTaskDto);
    public UUID updateTask(UUID taskId, UpdatedTaskDto updatedTaskDto);
    public UUID doneUndoneTask(UUID taskId);
    public UUID removeTask(UUID taskId);
    public List<Task> listTasks();
    public Task detailTask(UUID taskId);
}
