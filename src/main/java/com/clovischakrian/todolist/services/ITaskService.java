package com.clovischakrian.todolist.services;

import com.clovischakrian.todolist.dtos.NewTaskDto;
import com.clovischakrian.todolist.dtos.UpdatedTaskDto;
import com.clovischakrian.todolist.entities.Task;

import java.util.List;
import java.util.UUID;

public interface ITaskService {
    public UUID createTask(NewTaskDto newTaskDto);
    public UUID updateTask(UpdatedTaskDto updatedTaskDto);
    public UUID doneTask(UUID taksId);
    public UUID undoneTask(UUID taskId);
    public UUID removeTask(UUID taskId);
    public List<Task> listTasks();
    public Task detailTask(UUID taskId);
}
