package com.clovischakrian.todolist.services;

import com.clovischakrian.todolist.dtos.NewTaskDto;
import com.clovischakrian.todolist.dtos.UpdatedTaskDto;
import com.clovischakrian.todolist.entities.Task;
import com.clovischakrian.todolist.repositories.ITaskRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService implements ITaskService {
    @Autowired
    private ITaskRepository taskRepository;

    @Override
    public UUID createTask(NewTaskDto newTaskDto) {
        Task task = new Task(newTaskDto);

        this.taskRepository.save(task);

        return task.taskId;
    }

    @Override
    public UUID updateTask(UUID taskId, UpdatedTaskDto updatedTaskDto) {
        Task task = this.taskRepository.findById(taskId).orElseThrow(() -> new ValidationException("A task selecionada para atualizar não foi encontrada."));

        task.setTitle(updatedTaskDto.getTitle());
        task.setDescription(updatedTaskDto.getDescription());

        this.taskRepository.save(task);

        return task.taskId;
    }

    @Override
    public UUID doneUndoneTask(UUID taskId) {
        Task task = this.taskRepository.findById(taskId).orElseThrow(() -> new ValidationException("A task selecionada para concluir/desconcluir não foi encontrada."));

        if (task.done) {
            task.undoneTask();
            return taskId;
        }

        task.doneTask();

        return task.taskId;
    }

    @Override
    public UUID removeTask(UUID taskId) {
        Task task = this.taskRepository.findById(taskId).orElseThrow(() -> new ValidationException("A task selecionada para excluir não foi encontrada."));

        this.taskRepository.delete(task);

        return task.getTaskId();
    }

    @Override
    public List<Task> listTasks() {
        return this.taskRepository.findAll();
    }

    @Override
    public Task detailTask(UUID taskId) {
        return this.taskRepository.findById(taskId).orElseThrow(() -> new ValidationException("A task selecionada para detalhar não foi encontrada."));
    }
}
