package com.clovischakrian.todolist.services;

import com.clovischakrian.todolist.dtos.NewTaskDto;
import com.clovischakrian.todolist.dtos.UpdatedTaskDto;
import com.clovischakrian.todolist.entities.Task;
import com.clovischakrian.todolist.repositories.ITaskRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
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
        return this.taskRepository.findAll();
    }

    @Override
    public Task detailTask(UUID taskId) throws ValidationException {
        return this.taskRepository.findById(taskId).orElseThrow(() -> new ValidationException("A task selecionada para detalhar não foi encontrada."));
    }
}
