package com.clovischakrian.todolist.services;

import com.clovischakrian.todolist.dtos.NewTaskDto;
import com.clovischakrian.todolist.dtos.UpdatedTaskDto;
import com.clovischakrian.todolist.entities.Task;
import com.clovischakrian.todolist.repositories.ITaskRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class TaskService implements ITaskService {
    @Autowired
    private ITaskRepository taskRepository;

    @Override
    public UUID createTask(NewTaskDto newTaskDto) {
        return null;
    }

    @Override
    public UUID updateTask(UpdatedTaskDto updatedTaskDto) {
        return null;
    }

    @Override
    public UUID doneTask(UUID taksId) {
        return null;
    }

    @Override
    public UUID undoneTask(UUID taskId) {
        return null;
    }

    @Override
    public UUID removeTask(UUID taskId) {
        return null;
    }

    @Override
    public List<Task> listTasks() {
        return List.of();
    }

    @Override
    public Task detailTask(UUID taskId) {
        return null;
    }
}
